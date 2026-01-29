#pragma once
#include "MyGrammarVisitor.h"

struct GenContext {
    const Grammar& grammar;
    std::unordered_map<std::string, std::string> terminal2Token;
};
