#pragma once
#include "Generator.h"

class LexerGenerator : public Generator {
public:
    LexerGenerator(std::ostream& out, GenContext& ctx)
        : Generator(out, ctx) {}

    void generate();

    void generateLexer();
};