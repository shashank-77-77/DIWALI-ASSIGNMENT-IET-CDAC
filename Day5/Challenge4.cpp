// Coding Challenges 
// 4. You are given an integer array nums and an integer k. Rotate the array to the 
// right by k steps, where k is non-negative. 

#include <iostream>
#include <vector>
#include <algorithm> // for reverse
using namespace std;

void rotateArray(vector<int> &nums, int k) {
    int n = nums.size();
    if (n == 0) return;

    k = k % n; // handle cases where k > n
    if (k == 0) return;

    // Reverse technique — O(n) time, O(1) extra space
    reverse(nums.begin(), nums.end());
    reverse(nums.begin(), nums.begin() + k);
    reverse(nums.begin() + k, nums.end());
}

int main() {
    int n, k;
    cout << "Enter number of elements: ";
    cin >> n;

    vector<int> nums(n);
    cout << "Enter array elements: ";
    for (int i = 0; i < n; ++i) cin >> nums[i];

    cout << "Enter rotation steps (k): ";
    cin >> k;

    rotateArray(nums, k);

    cout << "Array after rotation: ";
    for (int num : nums) cout << num << " ";
    cout << endl;

    return 0;
}
