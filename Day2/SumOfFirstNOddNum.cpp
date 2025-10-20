// Sum of first n odd numbers 
// Input: Integer n 
// Output: Sum of first n odd numbers 

#include <iostream>
using namespace std;

int main() {
    int n;
    cout << "Enter the number of terms (n): ";
    cin >> n;

    int sum = n * n;

    cout << "Sum of first " << n << " odd numbers = " << sum << endl;

    return 0;
}