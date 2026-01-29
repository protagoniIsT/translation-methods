#include <libitmoantlr/Translator.h>

const std::unordered_map<std::string, std::string> Translator::src2DestType = {
    { "Int",     "int" },
    { "Integer", "long long" },
    { "Double",  "double" },
    { "Float",   "float" },
    { "Bool",    "bool" },
    { "Char",    "char" },
    { "String",  "std::string"}
};

const std::string Translator::INDENT = std::string(Translator::INDENT_SIZE, Translator::SPACE);

std::string Translator::translate(const std::string& input) {
    currIndent.clear();
    antlr4::ANTLRInputStream stream(input);
    GrammarLexer lexer(&stream);
    antlr4::CommonTokenStream tokens(&lexer);
    GrammarParser parser(&tokens);
    auto tree = parser.program();
    return std::any_cast<std::string>(visit(tree));
}

std::any Translator::visitProgram(GrammarParser::ProgramContext *ctx) {
    std::string prog;
    for (auto child : ctx->children) {
        if (!dynamic_cast<antlr4::tree::TerminalNode*>(child)) {
            prog += std::any_cast<std::string>(visit(child)) + "\n";
        }
    }
    return prog;
}

std::any Translator::visitFunDecl(GrammarParser::FunDeclContext *ctx) {
    std::string funName = ctx->NAME(0)->getText();

    auto types = std::any_cast<std::vector<std::string>>(visit(ctx->typeList()));
    std::string retType = types.back();

    std::vector<std::string> args;
    if (ctx->argList()) {
        args = std::any_cast<std::vector<std::string>>(visit(ctx->argList()));
    }

    std::string argStr;
    for (size_t i = 0; i < args.size(); ++i) {
        argStr += src2DestType.at(types[i]) + " " + args[i];
        if (i < args.size() - 1) argStr += ", ";
    }

    std::string result = src2DestType.at(retType) + " " + funName + "(" + argStr + ")";
    result += updateIndent('{');
    result += "\n";

    if (!ctx->guardClause().empty()) {
        for (auto g : ctx->guardClause()) {
            result += currIndent + std::any_cast<std::string>(visit(g)) + "\n";
        }
    } else {
        result += currIndent + "return " + std::any_cast<std::string>(visit(ctx->expr())) + ";\n";
    }

    result += updateIndent('}');
    return result;
}

std::any Translator::visitGuardClause(GrammarParser::GuardClauseContext *ctx) {
    auto cond = std::any_cast<std::string>(visit(ctx->guard()));
    auto body = std::any_cast<std::string>(visit(ctx->expr()));

    std::string output = "if (" + cond + ")";
    output += updateIndent('{');
    output += "\n";
    output += currIndent + "return " + body + ";\n";
    output += updateIndent('}');
    return output;
}

std::any Translator::visitGuard(GrammarParser::GuardContext *ctx) {
    if (ctx->OTHERWISE()) {
        return std::string("true");
    }
    return visit(ctx->expr());
}

std::any Translator::visitTypeList(GrammarParser::TypeListContext *ctx) {
    std::vector<std::string> result;
    result.push_back(ctx->TYPE()->getText());
    if (ctx->typeList()) {
        auto restTypes = std::any_cast<std::vector<std::string>>(visit(ctx->typeList()));
        result.insert(result.end(), restTypes.begin(), restTypes.end());
    }
    return result;
}

std::any Translator::visitArgList(GrammarParser::ArgListContext *ctx) {
    std::vector<std::string> args;
    for (auto name : ctx->NAME()) {
        args.push_back(name->getText());
    }
    return args;
}

std::any Translator::visitVarDecl(GrammarParser::VarDeclContext *ctx) {
    std::string name = ctx->NAME()->getText();
    auto types = std::any_cast<std::vector<std::string>>(visit(ctx->typeList()));
    std::string actualType = types.back();
    return src2DestType.at(actualType) + " " + name + ";";
}

std::any Translator::visitExpr(GrammarParser::ExprContext *ctx) {
    return visit(ctx->boolExpr());
}

std::any Translator::visitBoolExpr(GrammarParser::BoolExprContext *ctx) {
    auto res = std::any_cast<std::string>(visit(ctx->additiveExpr(0)));
    for (size_t i = 1; i < ctx->additiveExpr().size(); ++i) {
        std::string operatorSym = ctx->children[2 * i - 1]->getText();
        res += " " + operatorSym + " ";
        res += std::any_cast<std::string>(visit(ctx->additiveExpr(i)));
    }
    return res;
}

std::any Translator::visitAdditiveExpr(GrammarParser::AdditiveExprContext *ctx) {
    auto res = std::any_cast<std::string>(visit(ctx->mulExpr(0)));
    for (size_t i = 1; i < ctx->mulExpr().size(); ++i) {
        std::string operatorSym = ctx->children[2 * i - 1]->getText();
        res += " " + operatorSym + " ";
        res += std::any_cast<std::string>(visit(ctx->mulExpr(i)));
    }
    return res;
}

std::any Translator::visitMulExpr(GrammarParser::MulExprContext *ctx) {
    auto res = std::any_cast<std::string>(visit(ctx->atom(0)));
    for (size_t i = 1; i < ctx->atom().size(); ++i) {
        std::string operatorSym = ctx->children[2 * i - 1]->getText();
        res += " " + operatorSym + " ";
        res += std::any_cast<std::string>(visit(ctx->atom(i)));
    }
    return res;
}

std::any Translator::visitExprList(GrammarParser::ExprListContext *ctx) {
    auto res = std::any_cast<std::string>(visit(ctx->expr(0)));
    for (size_t i = 1; i < ctx->expr().size(); ++i) {
        std::string comma = ctx->children[2 * i - 1]->getText();
        res += comma + " ";
        res += std::any_cast<std::string>(visit(ctx->expr(i)));
    }
    return res;
}

std::any Translator::visitAtom(GrammarParser::AtomContext *ctx) {
    if (ctx->getStart()->getText() == "-")
        return "-" + std::any_cast<std::string>(visit(ctx->expr(0)));

    if (ctx->INT()) 
        return ctx->INT()->getText();

    if (ctx->TRUE())
        return ctx->TRUE()->getText();

    if (ctx->FALSE())
        return ctx->FALSE()->getText();

    if (ctx->NAME() && ctx->exprList()) 
        return ctx->NAME()->getText() + "(" + std::any_cast<std::string>(visit(ctx->exprList())) + ")";

    if (ctx->NAME())
        return ctx->NAME()->getText();

    if (ctx->expr().size() == 1) {
        auto inner = std::any_cast<std::string>(visit(ctx->expr(0)));
        return "(" + stripOuterParens(inner) + ")";
    }

    if (ctx->getStart()->getText() == "if") {
        std::string cond = std::any_cast<std::string>(visit(ctx->expr(0)));
        std::string thenExpr = std::any_cast<std::string>(visit(ctx->expr(1)));
        std::string elseExpr = std::any_cast<std::string>(visit(ctx->expr(2)));
        return "(" + cond + " ? " + thenExpr + " : " + elseExpr + ")";
    }

    throw std::runtime_error("Unexpected atom");
}


std::string Translator::updateIndent(char bracket) {
    if (bracket == '{') {
        currIndent += Translator::INDENT;
        return SPACE + std::string(1, bracket);
    } else {
        currIndent = currIndent.substr(0, currIndent.length() - Translator::INDENT_SIZE);
        return currIndent + bracket;
    }
}
