#include <string>
#include <vector>
#include <memory>
#include <utility>
#include <fstream>
#include <optional>

struct Tree {
    std::string node;
    std::optional<std::string> lexeme;
    std::vector<std::unique_ptr<Tree>> children;

    explicit Tree(std::string node_)
        : node(std::move(node_)) {}
        

    template <typename... Children>
    Tree(std::string n, Children&&... ch)
        : node(std::move(n))
    {
        (children.push_back(std::move(ch)), ...);
    }

    void addChild(std::unique_ptr<Tree> child) {
        children.push_back(std::move(child));
    }

    void toDot(std::ofstream& out, int& id) const {
        int myId = id++;
        out << "node" << myId << " [label=\"" << node << "\"];\n";
        for (auto& child : children) {
            int childId = id;
            child->toDot(out, id);
            out << "node" << myId << " -> node" << childId << ";\n";
        }
    }
};
