//{ Driver Code Starts
// Initial Template for C++
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
// User function Template for C++
class Solution {
  public:
    int nthFibonacci(int n){
        // code here
        int mod = 1000000007;
        int temp;
        int AN_MINUS_ONE = 1;
        int AN_MINUS_TWO = 0;
        if(n==1){
            return 0;
        } else if(n==2) {
            return 1;
        } else {
            for(int i=3;i<=n+1;i++){
                temp = ((AN_MINUS_ONE)%mod + (AN_MINUS_TWO%mod))%mod;
                AN_MINUS_TWO = AN_MINUS_ONE;
                AN_MINUS_ONE = temp;
            }
        }
        return temp;
    }
};

//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        Solution ob;
        cout << ob.nthFibonacci(n) << endl;
    }
    return 0;
}

// } Driver Code Ends