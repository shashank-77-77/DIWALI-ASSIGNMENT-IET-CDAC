// Sum of digits of a number 
// Input: Integer n 
// Output: Sum of all digits 

#include <iostream>
using namespace std;

int main() {
    int n;
    cout << "Enter a number: ";
    cin >> n;

    int sum = 0;
    int temp = n;

    while (temp != 0) {
        sum += temp % 10; 
        temp /= 10;         
    }

    cout << "Sum of digits = " << sum << endl;

    return 0;
}
