#include "../include/ParserGenerator.h"

#include <cctype>
#include <sstream>
#include <stdexcept>
#include <string>
#include <utility>
#include <vector>

namespace {

static inline std::string trim(std::string s) {
    size_t i = 0;
    while (i < s.size() && std::isspace(static_cast<unsigned char>(s[i]))) ++i;
    size_t j = s.size();
    while (j > i && std::isspace((unsigned char)s[j - 1])) --j;
    return s.substr(i, j - i);
}

static inline std::pair<std::string, std::string> parseReturnDecl(const std::string& inner) {
    std::string s = trim(inner);
    if (s.empty()) return {"std::any", "__ret"};

    std::istringstream iss(s);
    std::vector<std::string> toks;
    for (std::string t; iss >> t; ) toks.push_back(t);

    if (toks.size() < 2) return {"std::any", "__ret"};

    std::string var = toks.back();
    toks.pop_back();

    std::string type;
    for (size_t i = 0; i < toks.size(); ++i) {
        if (i) type += " ";
        type += toks[i];
    }
    return {type, var};
}

static inline std::string buildParamList(const RuleSignature& sig) {
    std::string out;
    for (size_t i = 0; i < sig.params.size(); ++i) {
        if (i) out += ", ";
        out += sig.params[i].first;
        out += " ";
        out += sig.params[i].second;
    }
    return out;
}

} // namespace

void ParserGenerator::generateParser() {
    buildFirst();
    buildFollow();
    buildTable();

    writeln("#pragma once");
    writeln("");

    if (!ctx.grammar.headerCode.empty()) {
        writeln(ctx.grammar.headerCode);
        writeln("");
    }

    writeln("#include \"./GeneratedLexer.h\"");
    writeln("#include \"Tree.h\"");
    writeln("#include <any>");
    writeln("#include <memory>");
    writeln("#include <fstream>");
    writeln("#include <stdexcept>");
    writeln("#include <string>");
    writeln("#include <vector>");
    writeln("");

    writeln("struct LabeledToken {");
    incIndLevel();
    writeln("std::string text;");
    decIndLevel();
    writeln("};");
    writeln("");

    writeln("struct ParseResult {");
    incIndLevel();
    writeln("std::unique_ptr<Tree> tree;");
    writeln("std::any attr;");
    decIndLevel();
    writeln("};");
    writeln("");

    writeln("class GeneratedParser {");
    writeln("public:");
    incIndLevel();

    writeln("ParseResult parse(std::ifstream& ifs) {");
    incIndLevel();
    writeln("lexer = std::make_unique<GeneratedLexer>(ifs);");
    writeln("lexer->nextToken();");
    writeln("return parse" + capitalize(ctx.grammar.start) + "();");
    decIndLevel();
    writeln("}");
    writeln("");

    decIndLevel();
    writeln("private:");
    incIndLevel();

    writeln("std::unique_ptr<GeneratedLexer> lexer;");
    writeln("");

    writeln("void expect(Token t) {");
    incIndLevel();
    writeln("if (lexer->getCurToken() != t) {");
    incIndLevel();
    writeln("throw std::runtime_error(\"Unexpected token\");");
    decIndLevel();
    writeln("}");
    decIndLevel();
    writeln("}");
    writeln("");

    for (auto& [rule, _] : ctx.grammar.parserRules) {
        const auto& sig = ctx.grammar.signatures.at(rule);
        const std::string fn = "parse" + capitalize(rule);

        const std::string params = buildParamList(sig);
        writeln("ParseResult " + fn + "(" + params + ") {");
        incIndLevel();

        std::string retType, retVar;
        if (sig.returns) {
            auto parsed = parseReturnDecl(*sig.returns);
            retType = parsed.first;
            retVar  = parsed.second;
            writeln(retType + " " + retVar + ";");
        }

        writeln("switch (lexer->getCurToken()) {");

        for (auto& [lookahead, prod] : table[rule]) {
            writeln("case Token::" + ctx.terminal2Token[lookahead] + ": {");
            incIndLevel();

            writeln("std::vector<std::unique_ptr<Tree>> children;");

            if (prod.symbols.size() == 1 && prod.symbols[0].kind == Product::EPS) {
                writeln("children.push_back(std::make_unique<Tree>(\"ε\"));");

                if (prod.action) {
                    writeln("{");
                    incIndLevel();
                    writeln(prod.action->code);
                    decIndLevel();
                    writeln("}");
                }

                writeln("ParseResult res;");
                writeln("res.tree = std::make_unique<Tree>(\"" + rule + "\", std::move(children));");
                if (sig.returns) {
                    writeln("res.attr = " + retVar + ";");
                } else {
                    writeln("res.attr = std::any{};");
                }
                writeln("return res;");

                decIndLevel();
                writeln("}");
                continue;
            }

            int tmpIdx = 0;
            for (const auto& sym : prod.symbols) {
                if (sym.kind == Product::TERMINAL) {
                    const std::string tok = ctx.terminal2Token[sym.name];
                    writeln("expect(Token::" + tok + ");");

                    if (!sym.label.empty()) {
                        writeln("LabeledToken " + sym.label + "{ lexer->getCurText() };");
                    }

                    writeln("children.push_back(std::make_unique<Tree>(\"" + sym.name + "\"));");
                    writeln("lexer->nextToken();");
                } else if (sym.kind == Product::NONTERMINAL) {
                    const std::string callArgs = sym.callArgs;
                    writeln("auto r" + std::to_string(tmpIdx) + " = parse" +
                            capitalize(sym.name) + "(" + callArgs + ");");
                    writeln("children.push_back(std::move(r" + std::to_string(tmpIdx) + ".tree));");

                    const auto& childSig = ctx.grammar.signatures.at(sym.name);
                    if (childSig.returns) {
                        auto [childType, _childVar] = parseReturnDecl(*childSig.returns);

                        std::string varName = sym.label.empty()
                            ? ("__v" + std::to_string(tmpIdx))
                            : sym.label;

                        writeln(childType + " " + varName + " = std::any_cast<" +
                                childType + ">(r" + std::to_string(tmpIdx) + ".attr);");
                    }

                    tmpIdx++;
                }
            }

            if (prod.action) {
                writeln("{");
                incIndLevel();
                writeln(prod.action->code);
                decIndLevel();
                writeln("}");
            }

            writeln("ParseResult res;");
            writeln("res.tree = std::make_unique<Tree>(\"" + rule + "\", std::move(children));");
            if (sig.returns) {
                writeln("res.attr = " + retVar + ";");
            } else {
                writeln("res.attr = std::any{};");
            }
            writeln("return res;");

            decIndLevel();
            writeln("}");
        }

        writeln("default:");
        writeln("throw std::runtime_error(\"Unexpected token in " + rule + "\");");
        writeln("}");

        decIndLevel();
        writeln("}");
        writeln("");
    }

    decIndLevel();
    writeln("};");
}

void ParserGenerator::buildFirst() {
    for (auto &t : ctx.grammar.terminals) {
        if (t != "ε")
            first[t] = {t};
    }

    for (auto &[nt, _] : ctx.grammar.parserRules)
        first[nt];

    bool changed = true;
    while (changed) {
        changed = false;
        for (auto &[A, prods] : ctx.grammar.parserRules) {
            for (auto &prod : prods) {
                const auto &symbols = prod.symbols;
                
                if (symbols.size() == 1 && symbols[0].kind == Product::EPS) {
                    changed |= first[A].insert("ε").second;
                    continue;
                }
                
                bool nullable = true;
                for (auto &sym : symbols) {
                    for (auto &x : first[sym.name])
                        if (x != "ε")
                            changed |= first[A].insert(x).second;

                    if (!first[sym.name].count("ε")) {
                        nullable = false;
                        break;
                    }
                }
                if (nullable) {
                    changed |= first[A].insert("ε").second;
                }
            }
        }
    }
}

void ParserGenerator::buildFollow() {
    for (auto &[nt, _] : ctx.grammar.parserRules) {
        follow[nt];
    }

    follow[ctx.grammar.start].insert("END");

    bool changed = true;
    while (changed) {
        changed = false;
        for (auto &[A, prods] : ctx.grammar.parserRules) {
            for (auto &prod : prods) {
                const auto &symbols = prod.symbols;
                for (size_t i = 0; i < symbols.size(); ++i) {
                    if (symbols[i].kind != Product::NONTERMINAL)
                        continue;

                    bool nullableSuffix = true;
                    for (size_t j = i + 1; j < symbols.size(); ++j) {
                        const auto &X = symbols[j];

                        for (auto &t : first[X.name])
                            if (t != "ε")
                                changed |= follow[symbols[i].name].insert(t).second;

                        if (!first[X.name].count("ε")) {
                            nullableSuffix = false;
                            break;
                        }
                    }


                    if (nullableSuffix)
                        for (auto &t : follow[A])
                            changed |= follow[symbols[i].name].insert(t).second;
                }
            }
        }
    }
}

void ParserGenerator::buildTable() {
    for (auto &[A, prods] : ctx.grammar.parserRules) {
        for (auto &prod : prods) {
            const auto &symbols = prod.symbols;

            std::unordered_set<std::string> firstAlpha;
            bool nullable = false;

            if (symbols.size() == 1 && symbols[0].kind == Product::EPS) {
                nullable = true;
            } else {
                nullable = true;
                for (auto &sym : symbols) {
                    for (auto &t : first[sym.name])
                        if (t != "ε")
                            firstAlpha.insert(t);

                    if (!first[sym.name].count("ε")) {
                        nullable = false;
                        break;
                    }
                }
            }

            for (auto &t : firstAlpha) {
                if (table[A].count(t))
                    throw std::runtime_error("Not LL(1): conflict in " + A);
                table[A][t] = prod;
            }

            if (nullable) {
                for (auto &t : follow[A]) {
                    if (table[A].count(t))
                        throw std::runtime_error("Not LL(1): nullable conflict in " + A);
                    table[A][t] = prod;
                }
            }
        }
    }
}
