#include <gtest/gtest.h>
#include <libitmoantlr/Translator.h>

#include "test_helper.h"

TEST(ANTLRTests, SimpleProgram) {
    Translator t;

    std::string input = "fac :: Int -> Int\n"
                        "fac n\n"
                        " | n == 0 = 1\n"
                        " | n > 0 = n * fac(n - 1)";

    std::string expected = "int fac(int n) {\n"
                           "    if (n == 0) {\n"
                           "        return 1;\n"
                           "    }\n"
                           "    if (n > 0) {\n"
                           "        return n * fac(n - 1);\n"
                           "    }\n"
                           "}\n";

    auto output = t.translate(input);
    EXPECT_EQ(output, expected);

    test_helper::write_sample(input, expected);
}

TEST(ANTLRTests, MaxFunction) {
    Translator t;

    std::string input =
        "max :: Int -> Int -> Int\n"
        "max a b = if a > b then a else b";

    std::string expected =
        "int max(int a, int b) {\n"
        "    return (a > b ? a : b);\n"
        "}\n";

    auto output = t.translate(input);
    EXPECT_EQ(output, expected);

    test_helper::write_sample(input, expected);
}

TEST(ANTLRTests, UnaryAbsAndSgn) {
    Translator t;

    std::string input =
        "negate :: Int -> Int\n"
        "negate x = -x";

    std::string expected =
        "int negate(int x) {\n"
        "    return -x;\n"
        "}\n";

    auto output = t.translate(input);
    EXPECT_EQ(output, expected);

    test_helper::write_sample(input, expected);
}

TEST(ANTLRTests, LongGuard) {
    Translator t;
    std::string input =
        "sign :: Int -> Int\n"
        "sign x\n"
        "    | x > 0 = 1\n"
        "    | x == 0 = 0\n"
        "    | x < 0 = -1";

    std::string expected =
        "int sign(int x) {\n"
        "    if (x > 0) {\n"
        "        return 1;\n"
        "    }\n"
        "    if (x == 0) {\n"
        "        return 0;\n"
        "    }\n"
        "    if (x < 0) {\n"
        "        return -1;\n"
        "    }\n"
        "}\n";

    auto output = t.translate(input);
    EXPECT_EQ(output, expected);

    test_helper::write_sample(input, expected);
}

TEST(ANTLRTests, RecursionNoGuards) {
    Translator t;
    std::string input =
        "fib :: Int -> Int\n"
        "fib n = fib(n - 1) + fib(n - 2)";

    std::string expected =
        "int fib(int n) {\n"
        "    return fib(n - 1) + fib(n - 2);\n"
        "}\n";

    auto output = t.translate(input);
    EXPECT_EQ(output, expected);

    test_helper::write_sample(input, expected);
}

TEST(ANTLRTests, NestedIf) {
    Translator t;
    std::string input =
        "f :: Int -> Int -> Int\n"
        "f x y = if x > 0 then (if y > 0 then x + y else x - y) else 0";

    std::string expected =
        "int f(int x, int y) {\n"
        "    return (x > 0 ? (y > 0 ? x + y : x - y) : 0);\n"
        "}\n";

    auto output = t.translate(input);
    EXPECT_EQ(output, expected);

    test_helper::write_sample(input, expected);
}

TEST(ANTLRTests, DoubleNestedIf) {
    Translator t;
    std::string input =
        "g :: Int -> Int -> Int\n"
        "g x y = if x > 0 then if y > 0 then x else -x else 0";

    std::string expected =
        "int g(int x, int y) {\n"
        "    return (x > 0 ? (y > 0 ? x : -x) : 0);\n"
        "}\n";

    auto output = t.translate(input);
    EXPECT_EQ(output, expected);

    test_helper::write_sample(input, expected);
}


TEST(ANTLRTests, MultipleArgFunctionCall) {
    Translator t;
    std::string input =
        "sum3 :: Int -> Int -> Int -> Int\n"
        "sum3 a b c = a + sum3(b, c, 1)";

    std::string expected =
        "int sum3(int a, int b, int c) {\n"
        "    return a + sum3(b, c, 1);\n"
        "}\n";

    auto output = t.translate(input);
    EXPECT_EQ(output, expected);

    test_helper::write_sample(input, expected);
}

TEST(ANTLRTests, GuardsWithInnerIfElse) {
    Translator t;
    std::string input =
        "f :: Int -> Int\n"
        "f x\n"
        "    | x > 10 = x * 2\n"
        "    | x < 5  = if x == 4 then 100 else 200";

    std::string expected =
        "int f(int x) {\n"
        "    if (x > 10) {\n"
        "        return x * 2;\n"
        "    }\n"
        "    if (x < 5) {\n"
        "        return (x == 4 ? 100 : 200);\n"
        "    }\n"
        "}\n";

    auto output = t.translate(input);
    EXPECT_EQ(output, expected);

    test_helper::write_sample(input, expected);
}

TEST(ANTLRTests, GCD) {
    Translator t;
    std::string input =
        "gcd :: Int -> Int -> Int\n"
        "gcd a b\n"
        "    | b == 0 = a\n"
        "    | otherwise = gcd(b, a % b)";

    std::string expected =
        "int gcd(int a, int b) {\n"
        "    if (b == 0) {\n"
        "        return a;\n"
        "    }\n"
        "    if (true) {\n"
        "        return gcd(b, a % b);\n"
        "    }\n"
        "}\n";

    auto output = t.translate(input);
    EXPECT_EQ(output, expected);

    test_helper::write_sample(input, expected);
}

TEST(ANTLRTests, IsPrime) {
    Translator t;
    std::string input =
        "isPrime :: Int -> Int -> Bool\n"
        "isPrime n i\n"
        "    | i * i > n = true\n"
        "    | n % i == 0 = false\n"
        "    | otherwise = isPrime(n, i + 1)";

    std::string expected =
        "bool isPrime(int n, int i) {\n"
        "    if (i * i > n) {\n"
        "        return true;\n"
        "    }\n"
        "    if (n % i == 0) {\n"
        "        return false;\n"
        "    }\n"
        "    if (true) {\n"
        "        return isPrime(n, i + 1);\n"
        "    }\n"
        "}\n";

    auto output = t.translate(input);
    EXPECT_EQ(output, expected);

    test_helper::write_sample(input, expected);
}


int main(int argc, char **argv) {
    testing::InitGoogleTest(&argc, argv);
    return RUN_ALL_TESTS();
}
