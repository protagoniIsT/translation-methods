#include "../include/Generator.h"

void Generator::writeln(const std::string& s) {
    for (int i = 0; i < indentLevel; ++i) out << INDENT;
    out << s << '\n';
}

void Generator::incIndLevel() {
    ++indentLevel;
}

void Generator::decIndLevel() {
    if (indentLevel > 0) --indentLevel;
}
