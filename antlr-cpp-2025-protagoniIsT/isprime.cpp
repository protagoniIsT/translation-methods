#include "assert.h"

bool isPrime(int n, int i) {
    if (i * i > n) {
        return true;
    }
    if (n % i == 0) {
        return false;
    }
    if (true) {
        return isPrime(n, i + 1);
    }
}

int main() {
    assert(isPrime(2, 2) == true);
    assert(isPrime(3, 2) == true);
    assert(isPrime(5, 2) == true);
    assert(isPrime(7, 2) == true);
    assert(isPrime(11, 2) == true);

    assert(isPrime(4, 2) == false);
    assert(isPrime(6, 2) == false);
    assert(isPrime(8, 2) == false);
    assert(isPrime(9, 2) == false);
    assert(isPrime(15, 2) == false);

    assert(isPrime(1, 2) == true);
    assert(isPrime(0, 2) == true);
    assert(isPrime(-5, 2) == true);

    assert(isPrime(97, 2) == true);
    assert(isPrime(100, 2) == false);

    return 0;
}