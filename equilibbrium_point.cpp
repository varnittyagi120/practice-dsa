//{ Driver Code Starts
#include <iostream>
using namespace std;


// } Driver Code Ends
class Solution {
  public:
    // Function to find equilibrium point in the array.
    // arr: input array
    // n: size of array
    int equilibriumPoint(long long arr[], int n) {
            int sum = 0;
            for(int i=0;i<n;i++){
                sum=sum+arr[i];
            }
            int leftSum = 0;
            for(int i=0;i<n;i++){
                sum=sum-arr[i];
                if(sum==leftSum){
                    return i+1;
                }
                leftSum+=arr[i];
            }
            return -1;
        
    }
};

//{ Driver Code Starts.

int main() {

    long long t;

    // taking testcases
    cin >> t;

    while (t--) {
        long long n;

        // taking input n
        cin >> n;
        long long a[n];

        // adding elements to the array
        for (long long i = 0; i < n; i++) {
            cin >> a[i];
        }

        Solution ob;

        // calling equilibriumPoint() function
        cout << ob.equilibriumPoint(a, n) << endl;
    }
    return 0;
}

// } Driver Code Ends