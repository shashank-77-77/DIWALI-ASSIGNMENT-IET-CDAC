// Reverse a number 
// Input: Integer n 
// Output: Reversed integer

#include <iostream>
using namespace std;

int main() {
    int n, reversed = 0, remainder;
    cout << "Enter an integer: ";
    cin >> n;

   
    while (n != 0) {
        remainder = n % 10;           
        reversed = reversed * 10 + remainder;  
        n /= 10;      
    }

    cout << "Reversed number = " << reversed << endl;

    return 0;
}
