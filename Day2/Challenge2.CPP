// Coding Challenges 
// Given an integer n, reverse its digits and return the reversed number. Ignore 
// leading zeros in the reversed result. 
#include <iostream>
using namespace std;

int main() {
    int n;
    cout << "Enter an integer: ";
    cin >> n;

    int reversed = 0;

    int sign = (n < 0) ? -1 : 1;
    n = abs(n);

    while (n != 0) {
        int digit = n % 10;
        reversed = reversed * 10 + digit;
        n /= 10;
    }

    reversed *= sign;

    cout << "Reversed number = " << reversed << endl;

    return 0;
}
