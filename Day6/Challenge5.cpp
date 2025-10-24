// Coding Challenges 
// 5. You are given two sorted arrays nums1 and nums2. Your task is to merge them 
// into a single array sorted in non-decreasing order 

#include <iostream>
#include <vector>
using namespace std;

vector<int> mergeSortedArrays(const vector<int> &nums1, const vector<int> &nums2) {
    vector<int> merged;
    int i = 0, j = 0;
    int n = nums1.size(), m = nums2.size();
    
    while (i < n && j < m) {
        if (nums1[i] <= nums2[j]) {
            merged.push_back(nums1[i]);
            i++;
        } else {
            merged.push_back(nums2[j]);
            j++;
        }
    }

    while (i < n) merged.push_back(nums1[i++]);
    while (j < m) merged.push_back(nums2[j++]);

    return merged;
}

int main() {
    int n1, n2;
    cout << "Enter size of first array: ";
    cin >> n1;
    vector<int> nums1(n1);
    cout << "Enter elements of first array (sorted): ";
    for (int i = 0; i < n1; ++i) cin >> nums1[i];

    cout << "Enter size of second array: ";
    cin >> n2;
    vector<int> nums2(n2);
    cout << "Enter elements of second array (sorted): ";
    for (int i = 0; i < n2; ++i) cin >> nums2[i];

    vector<int> merged = mergeSortedArrays(nums1, nums2);

    cout << "Merged array: ";
    for (int val : merged) cout << val << " ";
    cout << endl;

    return 0;
}
