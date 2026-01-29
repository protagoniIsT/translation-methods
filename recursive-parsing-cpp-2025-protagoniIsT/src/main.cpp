#include <iostream>
#include <fstream>
#include "Parser.h"

int main() {
    std::ifstream ifs("input.txt");
    if (!ifs.is_open()) {
        std::cerr << "Cannot open input.txt\n";
        return 1;
    }

    std::ofstream output("output.txt");

    try {
        Parser p;
        Tree root = p.parse(ifs);

        std::ofstream dot("tree.dot");
        dot << "digraph ParseTree {\n";
        int id = 0;
        root.toDot(dot, id);
        dot << "}\n";
        dot.close();

        std::cout << "Parsed successfully. Tree saved to tree.dot\n";
        output << "Parsed.";

    } catch (const ParseError& e) {
        std::cerr << "Parser error: " << e.what() << std::endl;
        output << "Not parsed.";
    }
}
