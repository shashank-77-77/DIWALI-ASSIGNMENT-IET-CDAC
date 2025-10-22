// Print multiplication table of a number 
// Input: Integer n 
// Output: Table from n × 1 to n × 10 

#include <iostream>
using namespace std;

int main() {
    int n;
    cout << "Enter a number: ";
    cin >> n;

    cout << "Multiplication Table of " << n << ":" << endl;

    for (int i = 1; i <= 10; ++i) {
        cout << n << " * " << i << " = " << n * i << endl;
    }

    return 0;
}

