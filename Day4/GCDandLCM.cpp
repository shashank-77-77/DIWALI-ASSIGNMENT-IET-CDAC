// Find GCD and LCM of two numbers 
// Input: a, b 
// Output: GCD and LCM 

#include <iostream>
using namespace std;

int findGCD(int a, int b) {
    while (b != 0) {
        int temp = b;
        b = a % b;
        a = temp;
    }
    return a;
}

int findLCM(int a, int b) {
    return (a * b) / findGCD(a, b);
}

int main() {
    int a, b;
    cout << "Enter two numbers: ";
    cin >> a >> b;

    int gcd = findGCD(a, b);
    int lcm = findLCM(a, b);

    cout << "GCD = " << gcd << endl;
    cout << "LCM = " << lcm << endl;

    return 0;
}
