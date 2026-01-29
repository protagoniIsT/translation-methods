#pragma once
#include "../antlr/GrammarBaseVisitor.h"
#include "../antlr/GrammarLexer.h"
#include <optional>

struct Product {
    enum { 
        TERMINAL, 
        NONTERMINAL, 
        EPS 
    } kind;
    std::string name;
    std::string label;
    std::string callArgs;
};

struct Action {
    std::string code;
};

struct Production {
    std::vector<Product> symbols;
    std::optional<Action> action;
};

struct RuleSignature {
    std::vector<std::pair<std::string, std::string>> params;
    std::optional<std::string> returns;
};

struct Grammar {
    std::string start;
    std::map<std::string, RuleSignature> signatures;
    std::set<std::string> nonTerminals;
    std::set<std::string> terminals;

    std::map<std::string, std::vector<Production>> parserRules;
    std::map<std::string, std::string> lexerRules;

    std::string headerCode;
};

class MyGrammarVisitor : public GrammarBaseVisitor {
public:

    virtual std::any visitGrammarSpec(GrammarParser::GrammarSpecContext *ctx) override ;

    virtual std::any visitHeader(GrammarParser::HeaderContext *ctx) override ;

    virtual std::any visitPRule(GrammarParser::PRuleContext *ctx) override ;

    virtual std::any visitParams(GrammarParser::ParamsContext *ctx) override ;

    virtual std::any visitParam(GrammarParser::ParamContext *ctx) override ;

    virtual std::any visitRets(GrammarParser::RetsContext *ctx) override ;

    virtual std::any visitAlternative(GrammarParser::AlternativeContext *ctx) override ;

    virtual std::any visitAction(GrammarParser::ActionContext *ctx) override ;

    virtual std::any visitElement(GrammarParser::ElementContext *ctx) override ;

    virtual std::any visitLabeledElement(GrammarParser::LabeledElementContext *ctx) override ;

    virtual std::any visitSymbolRef(GrammarParser::SymbolRefContext *ctx) override ;

    virtual std::any visitCallArgs(GrammarParser::CallArgsContext *ctx) override ;

    virtual std::any visitExprList(GrammarParser::ExprListContext *ctx) override ;

    virtual std::any visitExpression(GrammarParser::ExpressionContext *ctx) override ;

    virtual std::any visitAdditive(GrammarParser::AdditiveContext *ctx) override ;

    virtual std::any visitMultiplicative(GrammarParser::MultiplicativeContext *ctx) override ;

    virtual std::any visitPostfix(GrammarParser::PostfixContext *ctx) override ;

    virtual std::any visitPrimary(GrammarParser::PrimaryContext *ctx) override ;

    virtual std::any visitLRule(GrammarParser::LRuleContext *ctx) override ;

    virtual std::any visitRegex(GrammarParser::RegexContext *ctx) override ;

    virtual std::any visitRegexAlt(GrammarParser::RegexAltContext *ctx) override ;

    virtual std::any visitRegexElem(GrammarParser::RegexElemContext *ctx) override ;

    virtual std::any visitRegexAtom(GrammarParser::RegexAtomContext *ctx) override ;

    virtual std::any visitSuffix(GrammarParser::SuffixContext *ctx) override ;

    const Grammar& getGrammar() const {
        return grammar;
    }

private:
    Grammar grammar;

    static std::string stripParens(std::string s) {
        if (s.size() >= 2 && s.front() == '(' && s.back() == ')')
            return s.substr(1, s.size() - 2);
        return s;
    }

    static std::string getOriginalText(antlr4::ParserRuleContext* ctx) {
        auto* start = ctx->getStart();
        auto* stop  = ctx->getStop();

        if (!start || !stop) return "";

        auto* input = start->getInputStream();
        return input->getText(
            antlr4::misc::Interval(
                start->getStartIndex(),
                stop->getStopIndex()
            )
        );
    }

};