#pragma once
#include <fstream>
#include <cctype>
#include "ParseError.h"

enum class Token {
    FUN,
    NAME,
    LPAREN,
    RPAREN,
    COLON,
    COMMA,
    ARPAREN,
    ALPAREN,
    END
};

class Lexer {
public:
    Lexer(std::ifstream& ifs_);

    void nextToken();
    Token getCurToken();
    int getCurPos();
    int getTokenStartPos();

    std::string tokenToLiteral(Token token);

private:
    std::ifstream& ifs;
    int curChar;
    int curPos;
    int tokenStartPos;
    Token curToken;
    Token prevToken;

    static bool isBlank(int c);
    void nextChar();
};
