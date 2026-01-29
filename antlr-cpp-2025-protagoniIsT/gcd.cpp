#include <assert.h>

int gcd(int a, int b) {
    if (b == 0) {
        return a;
    }
    if (true) {
        return gcd(b, a % b);
    }
}

int main() {
    assert(gcd(48, 18) == 6);

    assert(gcd(5, 0) == 5);
    assert(gcd(0, 7) == 7);

    assert(gcd(42, 42) == 42);

    assert(gcd(17, 13) == 1);

    assert(gcd(100, 25) == 25);
    assert(gcd(81, 9) == 9);

    assert(gcd(123456, 7890) == 6);

    assert(gcd(18, 48) == 6);
}