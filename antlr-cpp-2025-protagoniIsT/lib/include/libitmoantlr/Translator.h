#ifndef LIBITMOANTLR_TRANSLATOR_H
#define LIBITMOANTLR_TRANSLATOR_H

#include "../../../lib/generated/libitmoantlr/GrammarBaseVisitor.h"
#include "../../../lib/generated/libitmoantlr/GrammarLexer.h"

class Translator : public GrammarBaseVisitor {
public:
    std::string translate(const std::string& input);

    std::any visitProgram(GrammarParser::ProgramContext *ctx) override;

    std::any visitFunDecl(GrammarParser::FunDeclContext *ctx) override;

    std::any visitGuardClause(GrammarParser::GuardClauseContext *ctx) override;

    std::any visitGuard(GrammarParser::GuardContext *ctx) override;

    std::any visitTypeList(GrammarParser::TypeListContext *ctx) override;

    std::any visitArgList(GrammarParser::ArgListContext *ctx) override;

    std::any visitVarDecl(GrammarParser::VarDeclContext *ctx) override;

    std::any visitExpr(GrammarParser::ExprContext *ctx) override;

    std::any visitBoolExpr(GrammarParser::BoolExprContext *ctx) override;

    std::any visitAdditiveExpr(GrammarParser::AdditiveExprContext *ctx) override;

    std::any visitMulExpr(GrammarParser::MulExprContext *ctx) override;

    std::any visitExprList(GrammarParser::ExprListContext *ctx) override;

    std::any visitAtom(GrammarParser::AtomContext *ctx) override;


private:
    static const std::unordered_map<std::string, std::string> src2DestType;

    std::string updateIndent(char bracket);

    static std::string stripOuterParens(const std::string& s) {
        if (s.size() >= 2 && s.front() == '(' && s.back() == ')') {
            return s.substr(1, s.size() - 2);
        }
        return s;
    }

    std::string currIndent = "";

    static constexpr char SPACE = ' ';

    static constexpr int INDENT_SIZE = 4;

    static const std::string INDENT;
};

#endif /* LIBITMOANTLR_TRANSLATOR_H */
