//{ Driver Code Starts
// Initial template for C++

#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
// User function template for C++

class Solution {
  public:
    // Function to return the count of the number of elements in
    // the intersection of two arrays.
    int NumberofElementsInIntersection(int a[], int b[], int n, int m) {
        // Your code goes here
        int max1 = INT_MIN;
        int max2 = INT_MIN;
        for(int i=0;i<n;i++){
            if(max1<a[i]) {
                max1 = a[i];
            }
        }
        
        for(int j=0;j<m;j++){
            if(max2<b[j]){
                max2 = b[j];
            }
        }
        int size = (max1>max2)?max1:max2;
        int result[size];
        for(int i=0;i<size;i++){
            result[i] = -1;
        }
        for(int i=0;i<n;i++){
            if(0<result[a[i]-1]){
                continue;
            } else {
                result[a[i]-1] = 1;
            }
        }
        
        for(int j=0;j<m;j++){
            if(0<result[b[j]-1]){
                result[b[j]-1] = result[b[j]-1]-1; 
            } 
        }
        int numberOfIntersactions = 0;
        for(int i=0;i<size;i++){
            if(result[i]==0){
                numberOfIntersactions++;
            }
        }
        return numberOfIntersactions;
    }
};

//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int n, m;
        cin >> n >> m;
        int a[n], b[m];
        for (int i = 0; i < n; i++) cin >> a[i];

        for (int i = 0; i < m; i++) cin >> b[i];
        Solution ob;
        cout << ob.NumberofElementsInIntersection(a, b, n, m) << endl;
    }
    return 0;
}
// } Driver Code Ends