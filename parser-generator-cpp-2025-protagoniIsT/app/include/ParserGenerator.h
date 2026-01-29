#pragma once
#include "Generator.h"
#include "LexerGenerator.h"
#include "Tree.h"

struct ParseResult {
    Tree tree;
    std::any attr;
};

class ParserGenerator : public Generator {
public:
    ParserGenerator(std::ostream& out, GenContext& ctx)
        : Generator(out, ctx) {}

    void generateParser();

private:
    std::unordered_map<std::string, std::unordered_set<std::string>> first;
    std::unordered_map<std::string, std::unordered_set<std::string>> follow;
    std::unordered_map<std::string, std::unordered_map<std::string, Production>> table;

    void buildFirst();
    void buildFollow();
    void buildTable();

    std::string capitalize(std::string s) {
        s[0] = toupper(s[0]);
        return s;
    }

    bool hasAttributes() const {
        for (const auto& [nt, sig] : ctx.grammar.signatures) {
            if (sig.returns.has_value()) return true;
            if (!sig.params.empty()) return true;
        }

        for (const auto& [nt, prods] : ctx.grammar.parserRules) {
            for (const auto& prod : prods) {
                if (prod.action.has_value()) return true;
            }
        }
        return false;
    }
};