#include "Lexer.h"

Lexer::Lexer(std::ifstream& ifs_) 
    : ifs(ifs_), curPos(0) {
    Lexer::nextChar();
}

void Lexer::nextToken() {
    prevToken = curToken;

    while (isBlank(curChar)) {
        nextChar();
    }

    tokenStartPos = curPos;
    
    switch (curChar) {
        case '(': {
            curToken = Token::LPAREN;
            nextChar();
            return;
        }
        case ')': {
            curToken = Token::RPAREN;
            nextChar();
            return;
        }
        case '<': {
            curToken = Token::ALPAREN;
            nextChar();
            return;
        }
        case '>': {
            curToken = Token::ARPAREN;
            nextChar();
            return;
        }
        case ':': {
            curToken = Token::COLON;
            nextChar();
            return;
        }
        case ',': {
            curToken = Token::COMMA;
            nextChar();
            return;
        }
        case EOF: {
            curToken = Token::END;
            return;
        }
    }

    if (std::isalpha(curChar)) {
        std::string s{};
        while (std::isalpha(curChar) || std::isdigit(curChar) || curChar == '_') {
            s += static_cast<char>(curChar);
            nextChar();
        }

        if (s == "fun") {
            curToken = Token::FUN;
        } else {
            curToken = Token::NAME;
        }

        return;
    }

    if (curChar == EOF) {
        throw ParseError("Unexpected end of file");
    } else {
        throw ParseError("Unexpected character '" + std::string(1, curChar) +
                     "' at position " + std::to_string(curPos));
    }
}

Token Lexer::getCurToken() {
    return curToken;
}

int Lexer::getCurPos() {
    return curPos;
}

int Lexer::getTokenStartPos() {
    return tokenStartPos;
}

bool Lexer::isBlank(int c) {
    return c == ' ' 
        || c == '\n'
        || c == '\r'
        || c == '\t';
}

void Lexer::nextChar() {
    curPos++;
    curChar = ifs.get();
}

std::string Lexer::tokenToLiteral(Token token) {
    switch (token) {
        case Token::FUN:     return "FUN";
        case Token::NAME:    return "NAME";
        case Token::LPAREN:  return "LPAREN";
        case Token::RPAREN:  return "RPAREN";
        case Token::ALPAREN: return "ALPAREN";
        case Token::ARPAREN: return "ARPAREN";
        case Token::COLON:   return "COLON";
        case Token::COMMA:   return "COMMA";
        case Token::END:     return "END";
        default:             return "UNKNOWN";
    }
}