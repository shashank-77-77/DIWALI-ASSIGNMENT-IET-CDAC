// Print number pattern (e.g., triangle, pyramid) 
// Input: Rows r 
// Output: Pattern using loops 

#include <iostream>
using namespace std;

int main() {
    int r;
    cout << "Enter number of rows: ";
    cin >> r;

    cout << "Number Pyramid Pattern:" << endl;

    for (int i = 1; i <= r; ++i) {
        for (int space = 1; space <= r - i; ++space) {
            cout << "  ";
        }

        for (int num = 1; num <= i; ++num) {
            cout << num << " ";
        }

        for (int num = i - 1; num >= 1; --num) {
            cout << num << " ";
        }

        cout << endl;
    }

    return 0;
}
