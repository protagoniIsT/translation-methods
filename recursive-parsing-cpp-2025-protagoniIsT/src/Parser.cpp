#include "Parser.h"

Tree Parser::parse(std::ifstream& ifs_) {
    lexer = std::make_unique<Lexer>(ifs_);
    lexer->nextToken();
    return parseS();
}

Tree Parser::parseS() {
    Token curToken = lexer->getCurToken();
    switch (curToken) {
        case Token::FUN: {
            lexer->nextToken();
            expect(Token::NAME);

            lexer->nextToken();
            expect(Token::LPAREN);

            lexer->nextToken();
            Tree params = parsePPrime();

            expect(Token::RPAREN);

            lexer->nextToken();
            Tree retType = parseR();

            return Tree("S", 
                        std::make_unique<Tree>("fun"), 
                        std::make_unique<Tree>("name"), 
                        std::make_unique<Tree>("("),
                        std::make_unique<Tree>(std::move(params)),                 
                        std::make_unique<Tree>(")"),
                        std::make_unique<Tree>(std::move(retType))
                    );
        }
        case Token::END: {
            return Tree("S");
        }
        default: {
            throw ParseError("Unexpected token occurred while parsing S: "
                + lexer->tokenToLiteral(curToken) + ". Position: "
                + std::to_string(lexer->getCurPos()));
        }
    }
}

Tree Parser::parsePPrime() {
    Token curToken = lexer->getCurToken();
    switch (curToken) {
        case Token::NAME: {
            Tree param = parseP();
            Tree rest = parsePDoublePrime();
            return Tree("P'", 
                        std::make_unique<Tree>(std::move(param)),
                        std::make_unique<Tree>(std::move(rest))
                    );
        }
        case Token::RPAREN:
        case Token::END: {
            return Tree("P'", std::make_unique<Tree>("ε"));
        }
        default: {
            throw ParseError("Unexpected token occurred while parsing P': "
                + lexer->tokenToLiteral(curToken) + ". Position: "
                + std::to_string(lexer->getCurPos()));
        }
    }
}

Tree Parser::parsePDoublePrime() {
    Token curToken = lexer->getCurToken();
    switch (curToken) {
        case Token::COMMA: {
            lexer->nextToken();
            Tree param = parseP();
            Tree rest = parsePDoublePrime();

            return Tree("P''",
                        std::make_unique<Tree>(","), 
                        std::make_unique<Tree>(std::move(param)),
                        std::make_unique<Tree>(std::move(rest))
                    );
        }
        case Token::RPAREN:
        case Token::END: {
            return Tree("P''", std::make_unique<Tree>("ε"));
        }
        default: {
            throw ParseError("Unexpected token occurred while parsing P'': "
                + lexer->tokenToLiteral(curToken) + ". Position: "
                + std::to_string(lexer->getCurPos()));
        }
    }
}

Tree Parser::parseP() {
    expect(Token::NAME);
    lexer->nextToken();

    expect(Token::COLON);
    lexer->nextToken();

    Tree type = parseT();

    return Tree("P", 
                std::make_unique<Tree>("name"), 
                std::make_unique<Tree>(":"),
                std::make_unique<Tree>(std::move(type))
            );
}

Tree Parser::parseR() {
    Token curToken = lexer->getCurToken();

    switch (curToken) {
        case Token::COLON: {
            lexer->nextToken();
            Tree type = parseT();
            return Tree("R", 
                        std::make_unique<Tree>(":"),
                        std::make_unique<Tree>(std::move(type))
                    );
        }
        case Token::END: {
            return Tree("R", std::make_unique<Tree>("ε"));
        }
        default: {
            throw ParseError("Expected end or colon + type after parameters");
        }
    }
}

Tree Parser::parseT() {
    expect(Token::NAME);
    lexer->nextToken();

    Tree ta = parseTA();

    return Tree("T",
                std::make_unique<Tree>("name"),
                std::make_unique<Tree>(std::move(ta))
    );
}

Tree Parser::parseTA() {
    Token curToken = lexer->getCurToken();

    switch (curToken) {
        case Token::ALPAREN: {
            lexer->nextToken();
            Tree t = parseT();
            Tree taPrime = parseTAPrime();

            expect(Token::ARPAREN);
            lexer->nextToken();

            return Tree("TA",
                        std::make_unique<Tree>("<"),
                        std::make_unique<Tree>(std::move(t)),
                        std::make_unique<Tree>(std::move(taPrime)),
                        std::make_unique<Tree>(">")
            );
        }
        case Token::COMMA:
        case Token::RPAREN:
        case Token::ARPAREN:
        case Token::END: {
            return Tree("TA", std::make_unique<Tree>("ε"));
        }
        default: {
            throw ParseError("Unexpected token while parsing TA: " +
                    lexer->tokenToLiteral(curToken) +
                    " at position " + std::to_string(lexer->getCurPos()));
        }
    }

}

Tree Parser::parseTAPrime() {
    Token curToken = lexer->getCurToken();

    switch (curToken) {
        case Token::COMMA: {
            lexer->nextToken();
            Tree t = parseT();
            Tree taPrime = parseTAPrime();

            return Tree("TA'",
                std::make_unique<Tree>(","),
                std::make_unique<Tree>(std::move(t)),
                std::make_unique<Tree>(std::move(taPrime))
            );
        }
        case Token::ARPAREN:
        case Token::END: {
            return Tree("TA'", std::make_unique<Tree>("ε"));
        }
        default: {
            throw ParseError("Unexpected token while parsing TA': " +
            lexer->tokenToLiteral(curToken) +
            " at position " + std::to_string(lexer->getCurPos()));
        }
    }
}

void Parser::expect(Token expected) {
    Token got = lexer->getCurToken();
    if (got != expected) {
        throw ParseError(
            "Expected " + lexer->tokenToLiteral(expected) +
            ", got " + lexer->tokenToLiteral(got) +
            " at position " + std::to_string(lexer->getTokenStartPos())
        );
    }
}
