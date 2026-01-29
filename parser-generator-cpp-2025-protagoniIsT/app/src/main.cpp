#include <iostream>
#include <stdexcept>
#include <filesystem>
#include <string>
#include <format>
#include <algorithm>
#include "../antlr/GrammarLexer.h"
#include "../antlr/GrammarParser.h"
#include "../include/MyGrammarVisitor.h"
#include "../include/LexerGenerator.h"
#include "../include/ParserGenerator.h"

void normalize(std::string &s) {
    s.erase(0, s.find_first_not_of(" \t"));
    s.erase(s.find_last_not_of(" \t") + 1);
    if (s.size() >= 2 && s.front() == '"' && s.back() == '"')
        s = s.substr(1, s.size() - 2);
}

void extractParam(std::ifstream &ifs, std::string &destParam) {
    std::getline(ifs, destParam, '=');
    std::getline(ifs, destParam);
    normalize(destParam);
}

int main() {
    std::ifstream ifs("grammar.in");
    if (!ifs.is_open()) {
        std::cerr << "Cannot open file 'grammar.in'\n";
        return 1;
    }

    std::string grammarFile, outputDir, showValue;

    extractParam(ifs, grammarFile);
    extractParam(ifs, outputDir);
    extractParam(ifs, showValue);

    std::filesystem::create_directories(outputDir);

    std::ifstream ifsg(grammarFile);
    if (!ifsg.is_open()) {
        std::cerr << std::format("Cannot open file '{}'\n", grammarFile);
        return 1;
    }

    antlr4::ANTLRInputStream stream(ifsg);
    GrammarLexer lexer(&stream);
    antlr4::CommonTokenStream tokens(&lexer);
    GrammarParser parser(&tokens);
    parser.removeErrorListeners();
    antlr4::ConsoleErrorListener errorListener;
    parser.addErrorListener(&errorListener);

    auto tree = parser.grammarSpec();

    if (parser.getNumberOfSyntaxErrors() == 0) {
        std::cout << "Grammar file parsed.\n";
        MyGrammarVisitor visitor;
        visitor.visit(tree);
        const Grammar& g = visitor.getGrammar();

        std::ofstream ofCMake(outputDir + "/CMakeLists.txt");
        ofCMake << R"(cmake_minimum_required(VERSION 3.16)
        project(generated_parser)

        set(CMAKE_CXX_STANDARD 20)

        add_executable(generated_parser
            main.cpp
        )
        )";

        std::filesystem::copy_file("./app/include/Tree.h", outputDir + "/Tree.h", 
            std::filesystem::copy_options::overwrite_existing);

        GenContext ctx{ g };

        std::ofstream ofsLexer(outputDir + "/GeneratedLexer.h");
        LexerGenerator lg(ofsLexer, ctx);
        lg.generateLexer();

        std::ofstream ofsParser(outputDir + "/GeneratedParser.h");
        ParserGenerator pg(ofsParser, ctx);
        pg.generateParser();

        std::ofstream ofMain(outputDir + "/main.cpp");

        if (showValue == "false") {
            ofMain << R"DELIM(#include "./GeneratedLexer.h"
        #include "./GeneratedParser.h"
        #include <iostream>
        #include <fstream>

        int main() {
            std::ifstream ifs("input.txt");
            std::ofstream output("output.txt");

            if (!ifs.is_open()) {
                std::cerr << "Cannot open input.txt\n";
                output << "Not parsed.";
                return 1;
            }

            try {
                GeneratedParser p;
                ParseResult pres = p.parse(ifs);
                output << "Parsed.";
            } catch (const std::runtime_error& e) {
                output << "Not parsed.";
            }

            return 0;
        })DELIM";
        } else {
            ofMain << R"DELIM(#include "./GeneratedLexer.h"
        #include "./GeneratedParser.h"
        #include <iostream>
        #include <fstream>
        #include <any>

        int main() {
            std::ifstream ifs("input.txt");
            std::ofstream output("output.txt");

            if (!ifs.is_open()) {
                std::cerr << "Cannot open input.txt\n";
                output << "Not parsed.";
                return 1;
            }

            try {
                GeneratedParser p;
                ParseResult pres = p.parse(ifs);

                std::ofstream dot("tree.dot");
                dot << "digraph ParseTree {\n";
                int id = 0;
                pres.tree->toDot(dot, id);
                dot << "}\n";
                dot.close();

                if (pres.attr.has_value()) {
                    std::cout << "value = " << std::any_cast<int>(pres.attr) << "\n";
                    output << std::any_cast<int>(pres.attr);
                }

                std::cout << "Parsed successfully. Tree saved to tree.dot\n";

            } catch (const std::runtime_error& e) {
                std::cerr << "Parser error: " << e.what() << std::endl;
                output << "Not parsed.";
            }

            return 0;
        })DELIM";
        }


    } else {
        std::cout << "Grammar file not parsed.\n";
    }

    
    return 0;
}
