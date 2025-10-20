// Check if a number is an Armstrong number 
// Input: Integer n 
// Output: True if sum of digits raised to power equals number 

#include <iostream>
#include <cmath>
using namespace std;

int main() {
    int n, original, remainder, digits = 0;
    double result = 0.0;

    cout << "Enter an integer: ";
    cin >> n;

    original = n;

    while (original != 0) {
        original /= 10;
        digits++;
    }

    original = n;

    while (original != 0) {
        remainder = original % 10;
        result += pow(remainder, digits);
        original /= 10;
    }

    if ((int)result == n)
        cout << "True " << n << " is an Armstrong number." << endl;
    else
        cout << "False " << n << " is not an Armstrong number." << endl;

    return 0;
}
