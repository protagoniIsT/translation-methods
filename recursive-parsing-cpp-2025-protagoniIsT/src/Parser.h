#pragma once
#include "Lexer.h"
#include "Tree.h"
#include <fstream>

class Parser {
public:
    Tree parse(std::ifstream& ifs_);

private:
    std::unique_ptr<Lexer> lexer;

    Tree parseS();
    Tree parsePPrime();
    Tree parsePDoublePrime();
    Tree parseP();
    Tree parseR();
    Tree parseT();
    Tree parseTA();
    Tree parseTAPrime();

    void expect(Token expected);
};
