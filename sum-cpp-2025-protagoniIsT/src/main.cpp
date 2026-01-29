#include <stdexcept>
#include <fstream>

int main() {
    std::ifstream ifile("input.txt");
    if (!ifile) {
        throw std::runtime_error("Cannot open input.txt");
    }
    int a, b;
    ifile >> a >> b;
    ifile.close();
    std::ofstream ofile("output.txt");
    ofile << a + b << std::endl;
    ofile.close();
}
