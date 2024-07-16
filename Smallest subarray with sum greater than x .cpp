//{ Driver Code Starts
// Initial template for C++

#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
class Solution {
  public:
    int smallestSubWithSum(int x, vector<int>& arr) {
        int min = INT_MAX;
        int sum = 0;
        int end = 0;
        int start = 0;
        while(end<arr.size()){
            sum = sum + arr[end];
            while(sum>x){
                int temp = (end-start)+1;
                sum = sum - arr[start];
                start++;
                if(temp<min){
                    min = temp;
                }
            }
            end++;
        }
        return min == INT_MAX ? 0 : min;
    }
};

//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    cin.ignore(); // Ignore the newline character after t

    while (t--) {
        vector<int> arr;
        int x;

        cin >> x;
        cin.ignore(); // Ignore the newline character after x

        string input;
        getline(cin, input); // Read the entire line for the array elements

        stringstream ss(input);
        int number;
        while (ss >> number) {
            arr.push_back(number);
        }

        Solution obj;
        cout << obj.smallestSubWithSum(x, arr) << endl;
    }

    return 0;
}
// } Driver Code Ends