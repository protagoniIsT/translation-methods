#pragma once
#include <string>
#include <vector>
#include <memory>
#include <utility>
#include <fstream>
#include <unordered_map>

struct Tree {
    std::string node;
    std::vector<std::unique_ptr<Tree>> children;
    std::unordered_map<std::string, int> attrs;

    explicit Tree(std::string node_)
        : node(std::move(node_)) {}
        
    Tree(std::string node_, std::vector<std::unique_ptr<Tree>> ch)
        : node(std::move(node_)), children(std::move(ch)) {}

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