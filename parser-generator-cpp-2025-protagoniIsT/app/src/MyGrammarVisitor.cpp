#include "../include/MyGrammarVisitor.h"

#include <stdexcept>
#include <utility>

namespace {

static std::string stripBraces(std::string s) {
    if (s.size() >= 2 && s.front() == '{' && s.back() == '}') {
        s = s.substr(1, s.size() - 2);
    }
    return s;
}

static std::string stringToRegex(const std::string& s) {
    std::string content = s;
    if (content.size() >= 2 && content.front() == '\'' && content.back() == '\'') {
        content = content.substr(1, content.size() - 2);
    }
    std::string out;
    for (char c : content) {
        if (c == '.' || c == '^' || c == '$' || c == '*' || c == '+' ||
            c == '?' || c == '(' || c == ')' || c == '[' || c == ']' ||
            c == '{' || c == '}' || c == '|' || c == '\\') {
            out += '\\';
        }
        out += c;
    }
    return out;
}

static std::string getBlockText(antlr4::tree::TerminalNode* block) {
    if (!block) return {};
    std::string text = block->getText();
    return stripBraces(text);
}

} // namespace


std::any MyGrammarVisitor::visitGrammarSpec(GrammarParser::GrammarSpecContext *ctx) {
    if (ctx->header()) {
        visit(ctx->header());
    }

    for (auto lr : ctx->lRule()) {
        visit(lr);
    }
    for (auto pr : ctx->pRule()) {
        visit(pr);
    }

    if (!ctx->pRule().empty()) {
        grammar.start = ctx->pRule(0)->NONTERM()->getText();
    } else {
        throw std::runtime_error("No parser rules found: start symbol is undefined");
    }

    return {};
}

std::any MyGrammarVisitor::visitHeader(GrammarParser::HeaderContext* ctx) {
    std::string text = getBlockText(ctx->BLOCK());
    grammar.headerCode = text;
    return {};
}

std::any MyGrammarVisitor::visitAction(GrammarParser::ActionContext *ctx) {
    Action a;
    a.code = getBlockText(ctx->BLOCK());
    return a;
}

std::any MyGrammarVisitor::visitRets(GrammarParser::RetsContext *ctx) {
    auto *pr = dynamic_cast<GrammarParser::PRuleContext*>(ctx->parent);
    if (!pr) {
        throw std::runtime_error("rets() is expected to be inside pRule");
    }

    const std::string ruleName = pr->NONTERM()->getText();
    std::string text = getBlockText(ctx->BLOCK());
    grammar.signatures[ruleName].returns = text;
    return {};
}



std::any MyGrammarVisitor::visitPRule(GrammarParser::PRuleContext *ctx) {
    const std::string lhs = ctx->NONTERM()->getText();
    grammar.nonTerminals.insert(lhs);

    if (ctx->params()) {
        visit(ctx->params());
    }
    if (ctx->rets()) {
        visit(ctx->rets());
    } else {
        (void)grammar.signatures[lhs];
    }

    for (auto alt : ctx->alternative()) {
        grammar.parserRules[lhs].push_back(std::any_cast<Production>(visit(alt)));
    }

    return {};
}

std::any MyGrammarVisitor::visitParams(GrammarParser::ParamsContext *ctx) {
    auto *pr = dynamic_cast<GrammarParser::PRuleContext*>(ctx->parent);
    if (!pr) {
        throw std::runtime_error("params() is expected to be inside pRule");
    }
    const std::string ruleName = pr->NONTERM()->getText();

    auto &sig = grammar.signatures[ruleName];
    for (auto p : ctx->param()) {
        sig.params.push_back(std::any_cast<std::pair<std::string, std::string>>(visit(p)));
    }
    return {};
}

std::any MyGrammarVisitor::visitParam(GrammarParser::ParamContext *ctx) {
    return std::make_pair(ctx->TYPE()->getText(), ctx->NONTERM()->getText());
}

std::any MyGrammarVisitor::visitAlternative(GrammarParser::AlternativeContext *ctx) {
    Production prod;

    for (auto el : ctx->element()) {
        auto seq = std::any_cast<std::vector<Product>>(visit(el));
        prod.symbols.insert(prod.symbols.end(), seq.begin(), seq.end());
    }

    if (prod.symbols.empty()) {
        prod.symbols.push_back(Product{Product::EPS, "ε"});
    }

    if (ctx->action()) {
        prod.action = std::any_cast<Action>(visit(ctx->action()));
    }

    return prod;
}

std::any MyGrammarVisitor::visitElement(GrammarParser::ElementContext *ctx) {
    return visit(ctx->labeledElement());
}

std::any MyGrammarVisitor::visitLabeledElement(GrammarParser::LabeledElementContext *ctx) {
    Product p = std::any_cast<Product>(visit(ctx->symbolRef()));

    if (ctx->NONTERM() && ctx->children.size() >= 3 && ctx->children[1]->getText() == "=") {
        p.label = ctx->NONTERM()->getText();
    }

    return std::vector<Product>{ p };
}

std::any MyGrammarVisitor::visitSymbolRef(GrammarParser::SymbolRefContext *ctx) {
    if (ctx->NONTERM()) {
        std::string name = ctx->NONTERM()->getText();
        grammar.nonTerminals.insert(name);

        Product p{ Product::NONTERMINAL, name, "", "" };

        if (ctx->callArgs()) {
            std::string ca = ctx->callArgs()->getText();
            p.callArgs = stripParens(ca); 
        }
        return p;
    }

    if (ctx->TERM()) {
        std::string t = ctx->TERM()->getText();
        grammar.terminals.insert(t);
        return Product{ Product::TERMINAL, t, "", "" };
    }

    if (ctx->STRING()) {
        std::string s = ctx->STRING()->getText();
        grammar.terminals.insert(s);
        return Product{ Product::TERMINAL, s, "", "" };
    }

    if (ctx->LITERAL()) {
        std::string l = ctx->LITERAL()->getText();
        grammar.terminals.insert(l);
        return Product{ Product::TERMINAL, l, "", "" };
    }

    throw std::runtime_error("Unexpected symbolRef");
}

std::any MyGrammarVisitor::visitCallArgs(GrammarParser::CallArgsContext *ctx) {
    if (ctx->exprList()) visit(ctx->exprList());
    return {};
}

std::any MyGrammarVisitor::visitExprList(GrammarParser::ExprListContext *ctx) {
    for (auto e : ctx->expression()) visit(e);
    return {};
}

std::any MyGrammarVisitor::visitExpression(GrammarParser::ExpressionContext *ctx) {
    return visitChildren(ctx);
}

std::any MyGrammarVisitor::visitAdditive(GrammarParser::AdditiveContext *ctx) {
    return visitChildren(ctx);
}

std::any MyGrammarVisitor::visitMultiplicative(GrammarParser::MultiplicativeContext *ctx) {
    return visitChildren(ctx);
}


std::any MyGrammarVisitor::visitLRule(GrammarParser::LRuleContext *ctx) {
    const std::string name = ctx->TERM()->getText();
    grammar.terminals.insert(name);

    grammar.lexerRules[name] = std::any_cast<std::string>(visit(ctx->regex()));
    return {};
}

std::any MyGrammarVisitor::visitRegex(GrammarParser::RegexContext *ctx) {
    std::string r;
    for (size_t i = 0; i < ctx->regexAlt().size(); ++i) {
        if (i) r += "|";
        r += std::any_cast<std::string>(visit(ctx->regexAlt(i)));
    }
    return r;
}

std::any MyGrammarVisitor::visitRegexAlt(GrammarParser::RegexAltContext *ctx) {
    std::string r;
    for (auto e : ctx->regexElem()) {
        r += std::any_cast<std::string>(visit(e));
    }
    return r;
}

std::any MyGrammarVisitor::visitRegexElem(GrammarParser::RegexElemContext *ctx) {
    std::string r = std::any_cast<std::string>(visit(ctx->regexAtom()));
    if (ctx->suffix()) r += ctx->suffix()->getText();
    return r;
}

std::any MyGrammarVisitor::visitRegexAtom(GrammarParser::RegexAtomContext *ctx) {
    if (ctx->STRING()) return stringToRegex(ctx->STRING()->getText());
    if (ctx->CHAR_CLASS()) return ctx->CHAR_CLASS()->getText();
    if (ctx->regex()) {
        return "(" + std::any_cast<std::string>(visit(ctx->regex())) + ")";
    }
    return ".";
}

std::any MyGrammarVisitor::visitSuffix(GrammarParser::SuffixContext *ctx) {
    return ctx->getText();
}

std::any MyGrammarVisitor::visitPostfix(GrammarParser::PostfixContext *ctx) {
    return visitChildren(ctx);
}

std::any MyGrammarVisitor::visitPrimary(GrammarParser::PrimaryContext *ctx) {
    return visitChildren(ctx);
}
