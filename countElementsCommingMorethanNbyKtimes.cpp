//{ Driver Code Starts
// A C++ program to print elements with count more than n/k

#include <iostream>
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution
{
    public:
    //Function to find all elements in array that appear more than n/k times.
    int countOccurence(int arr[], int n, int k) {
        // Your code here
        map<int, int> countOfElements;
        int appearance = n/k;
        for(int i=0;i<n;i++){
            if(0<countOfElements[arr[i]]){
                int temp = countOfElements[arr[i]];
                temp++;
                countOfElements[arr[i]] = temp;
            } else {
                countOfElements[arr[i]] = 1; 
            }
        }
        int result = 0;
        for(auto i=countOfElements.begin(); i!=countOfElements.end();i++){
            if(appearance < i->second){
                result++;
            }
        }
        return result;
    }
};


//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int n, i;
        cin >> n;

        int arr[n];

        for (i = 0; i < n; i++) cin >> arr[i];
        int k;
        cin >> k;
        Solution obj;
        cout << obj.countOccurence(arr, n, k) << endl;
    }
    return 0;
}

// } Driver Code Ends