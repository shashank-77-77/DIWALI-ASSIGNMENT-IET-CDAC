// Coding Challenges 
// 3. You are given an array of size n that contains distinct numbers from 0 to n. Your 
// task is to find the one number that is missing from the array. 

#include <iostream>
#include <vector>
using namespace std;

int findMissingNumber(const vector<int>& arr) {
    int n = arr.size();                   
    int totalSum = n * (n + 1) / 2;       
    int currentSum = 0;

    for (int num : arr) {
        currentSum += num;                
    }

    return totalSum - currentSum;         
}

int main() {
    int n;
    cout << "Enter the size of array (excluding the missing number): ";
    cin >> n;

    vector<int> arr(n);
    cout << "Enter " << n << " distinct numbers from 0 to " << n << " (one missing): ";
    for (int i = 0; i < n; ++i) {
        cin >> arr[i];
    }

    int missing = findMissingNumber(arr);
    cout << "The missing number is: " << missing << endl;

    return 0;
}
