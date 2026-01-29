#pragma once
#include <fstream>
#include <string>
#include <unordered_map>
#include <vector>
#include <regex>
#include <stdexcept>

enum class Token {
    END,
    INT,
    LOG,
    LPAREN,
    MINUS,
    PLUS,
    RPAREN,
    SLASH,
    STAR,
    WS,
};

static const std::vector<std::pair<std::string, Token>> LITERALS = {
};

static const std::unordered_map<std::string, Token> KEYWORDS = {
};

struct RegexRule { std::regex re; Token tok; bool skip; };
static const std::vector<RegexRule>& REGEX_RULES() {
    static const std::vector<RegexRule> rules = {
        { std::regex("^\\$"), Token::END, false },
        { std::regex("^[0-9]+"), Token::INT, false },
        { std::regex("^//"), Token::LOG, false },
        { std::regex("^\\("), Token::LPAREN, false },
        { std::regex("^-"), Token::MINUS, false },
        { std::regex("^\\+"), Token::PLUS, false },
        { std::regex("^\\)"), Token::RPAREN, false },
        { std::regex("^/"), Token::SLASH, false },
        { std::regex("^\\*"), Token::STAR, false },
        { std::regex("^[ \\t\\r\\n]+"), Token::WS, true },
    };
    return rules;
}

class GeneratedLexer {
public:
    explicit GeneratedLexer(std::ifstream& in) : ifs(in) { nextChar(); }
    void nextToken() {
        retry:
        curText.clear();
        while (isBlank(curChar)) nextChar();
        tokenStartPos = pos;
        if (curChar == EOF) { curTok = Token::END; return; }
        for (auto& [lit, tok] : LITERALS) {
            std::streampos sp = ifs.tellg(); int p = pos; int c = curChar;
            bool ok = true;
            for (char x : lit) { if (curChar != x) { ok = false; break; } curText.push_back(curChar); nextChar(); }
            if (ok) { curTok = tok; return; }
            ifs.clear(); ifs.seekg(sp); pos = p; curChar = c; curText.clear();
        }
        std::string chunk; std::streampos sp = ifs.tellg();
        int savedChar = curChar;
        for (int i = 0; i < 4096 && curChar != EOF; ++i) { chunk.push_back(curChar); nextChar(); }
        ifs.clear(); ifs.seekg(sp); curChar = savedChar;
        size_t best = 0; Token bt = Token::END; bool skip = false; std::smatch m;
        for (auto& r : REGEX_RULES()) { if (std::regex_search(chunk, m, r.re, std::regex_constants::match_continuous)) {
            if (m.length() > best) { best = m.length(); bt = r.tok; skip = r.skip; }
        }}
        if (best > 0) {
            for (size_t i = 0; i < best; ++i) { curText.push_back(curChar); nextChar(); }
            auto it = KEYWORDS.find(curText);
            if (it != KEYWORDS.end()) { curTok = it->second; return; }
            curTok = bt;
            if (skip) goto retry;
            return;
        }
        throw std::runtime_error("Unexpected character");
    }
    Token getCurToken() const { return curTok; }
    const std::string& getCurText() const { return curText; }
private:
    std::ifstream& ifs;
    int curChar = EOF;
    int pos = 0;
    int tokenStartPos = 0;
    Token curTok = Token::END;
    std::string curText;
    static bool isBlank(int c) { return c==' '||c=='\n'||c=='\r'||c=='\t'; }
    void nextChar() { curChar = ifs.get(); ++pos; }
};
