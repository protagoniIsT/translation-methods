#include "../include/LexerGenerator.h"

#include <algorithm>
#include <cctype>
#include <string>

static std::string cppEscape(const std::string& s) {
    std::string out;
    out.reserve(s.size() * 2);
    for (char c : s) {
        switch (c) {
            case '\\': out += "\\\\"; break;
            case '"':  out += "\\\""; break;
            case '\n': out += "\\n";  break;
            case '\r': out += "\\r";  break;
            case '\t': out += "\\t";  break;
            default:   out += c;      break;
        }
    }
    return out;
}

void LexerGenerator::generateLexer() {
    writeln("#pragma once");
    writeln("#include <fstream>");
    writeln("#include <string>");
    writeln("#include <unordered_map>");
    writeln("#include <vector>");
    writeln("#include <regex>");
    writeln("#include <stdexcept>");
    writeln("");

    writeln("enum class Token {");
    incIndLevel();

    int autoTok = 0;
    std::vector<std::string> literals;
    std::vector<std::string> keywords;

    for (const auto& t : ctx.grammar.terminals) {
        std::string enumName;

        if (!t.empty() && t[0] == '\'') {
            std::string lit = t.substr(1, t.size() - 2);

            bool isKeyword = !lit.empty() &&
                (std::isalpha((unsigned char)lit[0]) || lit[0] == '_') &&
                std::all_of(lit.begin(), lit.end(), [](unsigned char c){
                    return std::isalnum(c) || c == '_';
                });

            if (isKeyword) {
                std::string up = lit;
                std::transform(up.begin(), up.end(), up.begin(), ::toupper);
                enumName = up;
                keywords.push_back(lit);
            } else {
                enumName = "T_" + std::to_string(autoTok++);
                literals.push_back(lit);
            }
        } else {
            enumName = t;
        }

        ctx.terminal2Token[t] = enumName;
        writeln(enumName + ",");
    }

    decIndLevel();
    writeln("};\n");

    std::sort(literals.begin(), literals.end(),
              [](auto& a, auto& b){ return a.size() > b.size(); });

    writeln("static const std::vector<std::pair<std::string, Token>> LITERALS = {");
    incIndLevel();

    autoTok = 0;
    for (const auto& lit : literals) {
        writeln("{\"" + cppEscape(lit) + "\", Token::T_" + std::to_string(autoTok++) + "},");
    }

    decIndLevel();
    writeln("};\n");

    writeln("static const std::unordered_map<std::string, Token> KEYWORDS = {");
    incIndLevel();

    for (const auto& kw : keywords) {
        std::string up = kw;
        std::transform(up.begin(), up.end(), up.begin(), ::toupper);
        writeln("{\"" + cppEscape(kw) + "\", Token::" + up + "},");
    }

    decIndLevel();
    writeln("};\n");

    writeln("struct RegexRule { std::regex re; Token tok; bool skip; };");

    writeln("static const std::vector<RegexRule>& REGEX_RULES() {");
    incIndLevel();
    writeln("static const std::vector<RegexRule> rules = {");
    incIndLevel();

    for (const auto& [name, re] : ctx.grammar.lexerRules) {
        auto it = ctx.terminal2Token.find(name);
        if (it == ctx.terminal2Token.end()) continue;

        bool skip = (name == "WS");
        writeln("{ std::regex(\"^" + cppEscape(re) +
                "\"), Token::" + it->second +
                ", " + (skip ? "true" : "false") + " },");
    }

    decIndLevel();
    writeln("};");
    writeln("return rules;");
    decIndLevel();
    writeln("}\n");

    writeln("class GeneratedLexer {");
    writeln("public:");
    incIndLevel();

    writeln("explicit GeneratedLexer(std::ifstream& in) : ifs(in) { nextChar(); }");

    writeln("void nextToken() {");
    incIndLevel();
    writeln("retry:");
    writeln("curText.clear();");
    writeln("while (isBlank(curChar)) nextChar();");
    writeln("tokenStartPos = pos;");
    writeln("if (curChar == EOF) { curTok = Token::END; return; }");

    // literals
    writeln("for (auto& [lit, tok] : LITERALS) {");
    incIndLevel();
    writeln("std::streampos sp = ifs.tellg(); int p = pos; int c = curChar;");
    writeln("bool ok = true;");
    writeln("for (char x : lit) { if (curChar != x) { ok = false; break; } curText.push_back(curChar); nextChar(); }");
    writeln("if (ok) { curTok = tok; return; }");
    writeln("ifs.clear(); ifs.seekg(sp); pos = p; curChar = c; curText.clear();");
    decIndLevel();
    writeln("}");

    // regex
    writeln("std::string chunk; std::streampos sp = ifs.tellg();");
    writeln("int savedChar = curChar;");
    writeln("for (int i = 0; i < 4096 && curChar != EOF; ++i) { chunk.push_back(curChar); nextChar(); }");
    writeln("ifs.clear(); ifs.seekg(sp); curChar = savedChar;");

    writeln("size_t best = 0; Token bt = Token::END; bool skip = false; std::smatch m;");
    writeln("for (auto& r : REGEX_RULES()) { if (std::regex_search(chunk, m, r.re, std::regex_constants::match_continuous)) {");
    incIndLevel();
    writeln("if (m.length() > best) { best = m.length(); bt = r.tok; skip = r.skip; }");
    decIndLevel();
    writeln("}}");

    writeln("if (best > 0) {");
    incIndLevel();
    writeln("for (size_t i = 0; i < best; ++i) { curText.push_back(curChar); nextChar(); }");

    writeln("auto it = KEYWORDS.find(curText);");
    writeln("if (it != KEYWORDS.end()) { curTok = it->second; return; }");

    writeln("curTok = bt;");
    writeln("if (skip) goto retry;");
    writeln("return;");
    decIndLevel();
    writeln("}");

    writeln("throw std::runtime_error(\"Unexpected character\");");
    decIndLevel();
    writeln("}");

    writeln("Token getCurToken() const { return curTok; }");
    writeln("const std::string& getCurText() const { return curText; }");

    decIndLevel();
    writeln("private:");
    incIndLevel();

    writeln("std::ifstream& ifs;");
    writeln("int curChar = EOF;");
    writeln("int pos = 0;");
    writeln("int tokenStartPos = 0;");
    writeln("Token curTok = Token::END;");
    writeln("std::string curText;");

    writeln("static bool isBlank(int c) { return c==' '||c=='\\n'||c=='\\r'||c=='\\t'; }");

    writeln("void nextChar() { curChar = ifs.get(); ++pos; }");

    decIndLevel();
    writeln("};");
}
