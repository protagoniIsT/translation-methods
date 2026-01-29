#pragma once
#include <ostream>
#include "MyGrammarVisitor.h"
#include "GenContext.h"

class Generator {
protected:
    Generator(std::ostream& out, GenContext &ctx_) : out(out), ctx(ctx_) {}

    void writeln(const std::string& s);
    void incIndLevel();
    void decIndLevel();
    void generateCMake();

    std::ostream& out;
    GenContext& ctx;
private:
    int indentLevel = 0;
    static constexpr std::string INDENT = "    ";
};