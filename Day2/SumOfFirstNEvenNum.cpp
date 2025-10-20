//Sum of first n even numbers 
//Input: Integer n 
//Output: Sum of first n even numbers 

#include <iostream>
using namespace std;

int main() {
    int n;
    cout << "Enter the number of terms (n): ";
    cin >> n;

    int sum = n * (n + 1);

    cout << "Sum of first " << n << " even numbers = " << sum << endl;

    return 0;
}
