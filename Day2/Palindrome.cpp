// Check if a number is a palindrome 
// Input: Integer n 
// Output: True if reversed number equals original 

#include <iostream>
using namespace std;

int main() {
    int n, original, reversed = 0, remainder;
    cout << "Enter an integer: ";
    cin >> n;

    original = n;

    while (n != 0) {
        remainder = n % 10;
        reversed = reversed * 10 + remainder;
        n /= 10;
    }

    if (original == reversed)
        cout << "True ssthe number is a palindrome." << endl;
    else
        cout << "False the number is not a palindrome." << endl;

    return 0;
}
