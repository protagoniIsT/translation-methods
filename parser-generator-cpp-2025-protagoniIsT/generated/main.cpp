#include "./GeneratedLexer.h"
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
        }