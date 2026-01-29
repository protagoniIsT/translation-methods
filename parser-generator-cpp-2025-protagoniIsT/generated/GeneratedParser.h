#pragma once


    #include <string>
    #include <stdexcept>
    #include <cmath>

    int divide(int a, int b) {
        if (b == 0) throw std::runtime_error("division by zero");
        int res = a / b;
        if (a % b != 0 && ((a < 0) != (b < 0))) res--;
        return res;
    }

    int ilog(int base, int arg) {
        if (base <= 1 || arg <= 0) throw std::runtime_error("invalid log arguments");
        return (int)(std::log(arg) / std::log(base));
    }


#include "./GeneratedLexer.h"
#include "Tree.h"
#include <any>
#include <memory>
#include <fstream>
#include <stdexcept>
#include <string>
#include <vector>

struct LabeledToken {
    std::string text;
};

struct ParseResult {
    std::unique_ptr<Tree> tree;
    std::any attr;
};

class GeneratedParser {
public:
    ParseResult parse(std::ifstream& ifs) {
        lexer = std::make_unique<GeneratedLexer>(ifs);
        lexer->nextToken();
        return parseStart();
    }
    
private:
    std::unique_ptr<GeneratedLexer> lexer;
    
    void expect(Token t) {
        if (lexer->getCurToken() != t) {
            throw std::runtime_error("Unexpected token");
        }
    }
    
    ParseResult parseExpr() {
        int val;
        switch (lexer->getCurToken()) {
        case Token::LPAREN: {
            std::vector<std::unique_ptr<Tree>> children;
            auto r0 = parseTerm();
            children.push_back(std::move(r0.tree));
            int t = std::any_cast<int>(r0.attr);
            auto r1 = parseExprRest(t);
            children.push_back(std::move(r1.tree));
            int r = std::any_cast<int>(r1.attr);
            {
                 val = r; 
            }
            ParseResult res;
            res.tree = std::make_unique<Tree>("expr", std::move(children));
            res.attr = val;
            return res;
        }
        case Token::MINUS: {
            std::vector<std::unique_ptr<Tree>> children;
            auto r0 = parseTerm();
            children.push_back(std::move(r0.tree));
            int t = std::any_cast<int>(r0.attr);
            auto r1 = parseExprRest(t);
            children.push_back(std::move(r1.tree));
            int r = std::any_cast<int>(r1.attr);
            {
                 val = r; 
            }
            ParseResult res;
            res.tree = std::make_unique<Tree>("expr", std::move(children));
            res.attr = val;
            return res;
        }
        case Token::INT: {
            std::vector<std::unique_ptr<Tree>> children;
            auto r0 = parseTerm();
            children.push_back(std::move(r0.tree));
            int t = std::any_cast<int>(r0.attr);
            auto r1 = parseExprRest(t);
            children.push_back(std::move(r1.tree));
            int r = std::any_cast<int>(r1.attr);
            {
                 val = r; 
            }
            ParseResult res;
            res.tree = std::make_unique<Tree>("expr", std::move(children));
            res.attr = val;
            return res;
        }
        default:
        throw std::runtime_error("Unexpected token in expr");
        }
    }
    
    ParseResult parseExprRest(int acc) {
        int val;
        switch (lexer->getCurToken()) {
        case Token::END: {
            std::vector<std::unique_ptr<Tree>> children;
            children.push_back(std::make_unique<Tree>("ε"));
            {
                 val = acc; 
            }
            ParseResult res;
            res.tree = std::make_unique<Tree>("exprRest", std::move(children));
            res.attr = val;
            return res;
        }
        case Token::RPAREN: {
            std::vector<std::unique_ptr<Tree>> children;
            children.push_back(std::make_unique<Tree>("ε"));
            {
                 val = acc; 
            }
            ParseResult res;
            res.tree = std::make_unique<Tree>("exprRest", std::move(children));
            res.attr = val;
            return res;
        }
        case Token::MINUS: {
            std::vector<std::unique_ptr<Tree>> children;
            expect(Token::MINUS);
            children.push_back(std::make_unique<Tree>("MINUS"));
            lexer->nextToken();
            auto r0 = parseTerm();
            children.push_back(std::move(r0.tree));
            int t = std::any_cast<int>(r0.attr);
            auto r1 = parseExprRest(acc-t);
            children.push_back(std::move(r1.tree));
            int r = std::any_cast<int>(r1.attr);
            {
                 val = r; 
            }
            ParseResult res;
            res.tree = std::make_unique<Tree>("exprRest", std::move(children));
            res.attr = val;
            return res;
        }
        case Token::PLUS: {
            std::vector<std::unique_ptr<Tree>> children;
            expect(Token::PLUS);
            children.push_back(std::make_unique<Tree>("PLUS"));
            lexer->nextToken();
            auto r0 = parseTerm();
            children.push_back(std::move(r0.tree));
            int t = std::any_cast<int>(r0.attr);
            auto r1 = parseExprRest(acc+t);
            children.push_back(std::move(r1.tree));
            int r = std::any_cast<int>(r1.attr);
            {
                 val = r; 
            }
            ParseResult res;
            res.tree = std::make_unique<Tree>("exprRest", std::move(children));
            res.attr = val;
            return res;
        }
        default:
        throw std::runtime_error("Unexpected token in exprRest");
        }
    }
    
    ParseResult parseFactor() {
        int val;
        switch (lexer->getCurToken()) {
        case Token::LPAREN: {
            std::vector<std::unique_ptr<Tree>> children;
            expect(Token::LPAREN);
            children.push_back(std::make_unique<Tree>("LPAREN"));
            lexer->nextToken();
            auto r0 = parseExpr();
            children.push_back(std::move(r0.tree));
            int e = std::any_cast<int>(r0.attr);
            expect(Token::RPAREN);
            children.push_back(std::make_unique<Tree>("RPAREN"));
            lexer->nextToken();
            {
                 val = e; 
            }
            ParseResult res;
            res.tree = std::make_unique<Tree>("factor", std::move(children));
            res.attr = val;
            return res;
        }
        case Token::MINUS: {
            std::vector<std::unique_ptr<Tree>> children;
            expect(Token::MINUS);
            children.push_back(std::make_unique<Tree>("MINUS"));
            lexer->nextToken();
            auto r0 = parseFactor();
            children.push_back(std::move(r0.tree));
            int f = std::any_cast<int>(r0.attr);
            {
                 val = -f; 
            }
            ParseResult res;
            res.tree = std::make_unique<Tree>("factor", std::move(children));
            res.attr = val;
            return res;
        }
        case Token::INT: {
            std::vector<std::unique_ptr<Tree>> children;
            expect(Token::INT);
            LabeledToken n{ lexer->getCurText() };
            children.push_back(std::make_unique<Tree>("INT"));
            lexer->nextToken();
            {
                 val = std::stoi(n.text); 
            }
            ParseResult res;
            res.tree = std::make_unique<Tree>("factor", std::move(children));
            res.attr = val;
            return res;
        }
        default:
        throw std::runtime_error("Unexpected token in factor");
        }
    }
    
    ParseResult parseLogExpr() {
        int val;
        switch (lexer->getCurToken()) {
        case Token::LPAREN: {
            std::vector<std::unique_ptr<Tree>> children;
            auto r0 = parseFactor();
            children.push_back(std::move(r0.tree));
            int f = std::any_cast<int>(r0.attr);
            auto r1 = parseLogRest(f);
            children.push_back(std::move(r1.tree));
            int r = std::any_cast<int>(r1.attr);
            {
                 val = r; 
            }
            ParseResult res;
            res.tree = std::make_unique<Tree>("logExpr", std::move(children));
            res.attr = val;
            return res;
        }
        case Token::MINUS: {
            std::vector<std::unique_ptr<Tree>> children;
            auto r0 = parseFactor();
            children.push_back(std::move(r0.tree));
            int f = std::any_cast<int>(r0.attr);
            auto r1 = parseLogRest(f);
            children.push_back(std::move(r1.tree));
            int r = std::any_cast<int>(r1.attr);
            {
                 val = r; 
            }
            ParseResult res;
            res.tree = std::make_unique<Tree>("logExpr", std::move(children));
            res.attr = val;
            return res;
        }
        case Token::INT: {
            std::vector<std::unique_ptr<Tree>> children;
            auto r0 = parseFactor();
            children.push_back(std::move(r0.tree));
            int f = std::any_cast<int>(r0.attr);
            auto r1 = parseLogRest(f);
            children.push_back(std::move(r1.tree));
            int r = std::any_cast<int>(r1.attr);
            {
                 val = r; 
            }
            ParseResult res;
            res.tree = std::make_unique<Tree>("logExpr", std::move(children));
            res.attr = val;
            return res;
        }
        default:
        throw std::runtime_error("Unexpected token in logExpr");
        }
    }
    
    ParseResult parseLogRest(int acc) {
        int val;
        switch (lexer->getCurToken()) {
        case Token::MINUS: {
            std::vector<std::unique_ptr<Tree>> children;
            children.push_back(std::make_unique<Tree>("ε"));
            {
                 val = acc; 
            }
            ParseResult res;
            res.tree = std::make_unique<Tree>("logRest", std::move(children));
            res.attr = val;
            return res;
        }
        case Token::PLUS: {
            std::vector<std::unique_ptr<Tree>> children;
            children.push_back(std::make_unique<Tree>("ε"));
            {
                 val = acc; 
            }
            ParseResult res;
            res.tree = std::make_unique<Tree>("logRest", std::move(children));
            res.attr = val;
            return res;
        }
        case Token::STAR: {
            std::vector<std::unique_ptr<Tree>> children;
            children.push_back(std::make_unique<Tree>("ε"));
            {
                 val = acc; 
            }
            ParseResult res;
            res.tree = std::make_unique<Tree>("logRest", std::move(children));
            res.attr = val;
            return res;
        }
        case Token::SLASH: {
            std::vector<std::unique_ptr<Tree>> children;
            children.push_back(std::make_unique<Tree>("ε"));
            {
                 val = acc; 
            }
            ParseResult res;
            res.tree = std::make_unique<Tree>("logRest", std::move(children));
            res.attr = val;
            return res;
        }
        case Token::END: {
            std::vector<std::unique_ptr<Tree>> children;
            children.push_back(std::make_unique<Tree>("ε"));
            {
                 val = acc; 
            }
            ParseResult res;
            res.tree = std::make_unique<Tree>("logRest", std::move(children));
            res.attr = val;
            return res;
        }
        case Token::RPAREN: {
            std::vector<std::unique_ptr<Tree>> children;
            children.push_back(std::make_unique<Tree>("ε"));
            {
                 val = acc; 
            }
            ParseResult res;
            res.tree = std::make_unique<Tree>("logRest", std::move(children));
            res.attr = val;
            return res;
        }
        case Token::LOG: {
            std::vector<std::unique_ptr<Tree>> children;
            expect(Token::LOG);
            children.push_back(std::make_unique<Tree>("LOG"));
            lexer->nextToken();
            auto r0 = parseLogExpr();
            children.push_back(std::move(r0.tree));
            int f = std::any_cast<int>(r0.attr);
            {
                 val = ilog(f, acc); 
            }
            ParseResult res;
            res.tree = std::make_unique<Tree>("logRest", std::move(children));
            res.attr = val;
            return res;
        }
        default:
        throw std::runtime_error("Unexpected token in logRest");
        }
    }
    
    ParseResult parseStart() {
        int val;
        switch (lexer->getCurToken()) {
        case Token::INT: {
            std::vector<std::unique_ptr<Tree>> children;
            auto r0 = parseExpr();
            children.push_back(std::move(r0.tree));
            int e = std::any_cast<int>(r0.attr);
            expect(Token::END);
            children.push_back(std::make_unique<Tree>("END"));
            lexer->nextToken();
            {
                 val = e; 
            }
            ParseResult res;
            res.tree = std::make_unique<Tree>("start", std::move(children));
            res.attr = val;
            return res;
        }
        case Token::MINUS: {
            std::vector<std::unique_ptr<Tree>> children;
            auto r0 = parseExpr();
            children.push_back(std::move(r0.tree));
            int e = std::any_cast<int>(r0.attr);
            expect(Token::END);
            children.push_back(std::make_unique<Tree>("END"));
            lexer->nextToken();
            {
                 val = e; 
            }
            ParseResult res;
            res.tree = std::make_unique<Tree>("start", std::move(children));
            res.attr = val;
            return res;
        }
        case Token::LPAREN: {
            std::vector<std::unique_ptr<Tree>> children;
            auto r0 = parseExpr();
            children.push_back(std::move(r0.tree));
            int e = std::any_cast<int>(r0.attr);
            expect(Token::END);
            children.push_back(std::make_unique<Tree>("END"));
            lexer->nextToken();
            {
                 val = e; 
            }
            ParseResult res;
            res.tree = std::make_unique<Tree>("start", std::move(children));
            res.attr = val;
            return res;
        }
        default:
        throw std::runtime_error("Unexpected token in start");
        }
    }
    
    ParseResult parseTerm() {
        int val;
        switch (lexer->getCurToken()) {
        case Token::INT: {
            std::vector<std::unique_ptr<Tree>> children;
            auto r0 = parseLogExpr();
            children.push_back(std::move(r0.tree));
            int f = std::any_cast<int>(r0.attr);
            auto r1 = parseTermRest(f);
            children.push_back(std::move(r1.tree));
            int r = std::any_cast<int>(r1.attr);
            {
                 val = r; 
            }
            ParseResult res;
            res.tree = std::make_unique<Tree>("term", std::move(children));
            res.attr = val;
            return res;
        }
        case Token::MINUS: {
            std::vector<std::unique_ptr<Tree>> children;
            auto r0 = parseLogExpr();
            children.push_back(std::move(r0.tree));
            int f = std::any_cast<int>(r0.attr);
            auto r1 = parseTermRest(f);
            children.push_back(std::move(r1.tree));
            int r = std::any_cast<int>(r1.attr);
            {
                 val = r; 
            }
            ParseResult res;
            res.tree = std::make_unique<Tree>("term", std::move(children));
            res.attr = val;
            return res;
        }
        case Token::LPAREN: {
            std::vector<std::unique_ptr<Tree>> children;
            auto r0 = parseLogExpr();
            children.push_back(std::move(r0.tree));
            int f = std::any_cast<int>(r0.attr);
            auto r1 = parseTermRest(f);
            children.push_back(std::move(r1.tree));
            int r = std::any_cast<int>(r1.attr);
            {
                 val = r; 
            }
            ParseResult res;
            res.tree = std::make_unique<Tree>("term", std::move(children));
            res.attr = val;
            return res;
        }
        default:
        throw std::runtime_error("Unexpected token in term");
        }
    }
    
    ParseResult parseTermRest(int acc) {
        int val;
        switch (lexer->getCurToken()) {
        case Token::PLUS: {
            std::vector<std::unique_ptr<Tree>> children;
            children.push_back(std::make_unique<Tree>("ε"));
            {
                 val = acc; 
            }
            ParseResult res;
            res.tree = std::make_unique<Tree>("termRest", std::move(children));
            res.attr = val;
            return res;
        }
        case Token::MINUS: {
            std::vector<std::unique_ptr<Tree>> children;
            children.push_back(std::make_unique<Tree>("ε"));
            {
                 val = acc; 
            }
            ParseResult res;
            res.tree = std::make_unique<Tree>("termRest", std::move(children));
            res.attr = val;
            return res;
        }
        case Token::RPAREN: {
            std::vector<std::unique_ptr<Tree>> children;
            children.push_back(std::make_unique<Tree>("ε"));
            {
                 val = acc; 
            }
            ParseResult res;
            res.tree = std::make_unique<Tree>("termRest", std::move(children));
            res.attr = val;
            return res;
        }
        case Token::END: {
            std::vector<std::unique_ptr<Tree>> children;
            children.push_back(std::make_unique<Tree>("ε"));
            {
                 val = acc; 
            }
            ParseResult res;
            res.tree = std::make_unique<Tree>("termRest", std::move(children));
            res.attr = val;
            return res;
        }
        case Token::SLASH: {
            std::vector<std::unique_ptr<Tree>> children;
            expect(Token::SLASH);
            children.push_back(std::make_unique<Tree>("SLASH"));
            lexer->nextToken();
            auto r0 = parseLogExpr();
            children.push_back(std::move(r0.tree));
            int f = std::any_cast<int>(r0.attr);
            auto r1 = parseTermRest(divide(acc,f));
            children.push_back(std::move(r1.tree));
            int r = std::any_cast<int>(r1.attr);
            {
                 val = r; 
            }
            ParseResult res;
            res.tree = std::make_unique<Tree>("termRest", std::move(children));
            res.attr = val;
            return res;
        }
        case Token::STAR: {
            std::vector<std::unique_ptr<Tree>> children;
            expect(Token::STAR);
            children.push_back(std::make_unique<Tree>("STAR"));
            lexer->nextToken();
            auto r0 = parseLogExpr();
            children.push_back(std::move(r0.tree));
            int f = std::any_cast<int>(r0.attr);
            auto r1 = parseTermRest(acc*f);
            children.push_back(std::move(r1.tree));
            int r = std::any_cast<int>(r1.attr);
            {
                 val = r; 
            }
            ParseResult res;
            res.tree = std::make_unique<Tree>("termRest", std::move(children));
            res.attr = val;
            return res;
        }
        default:
        throw std::runtime_error("Unexpected token in termRest");
        }
    }
    
};
