//{ Driver Code Starts
#include <bits/stdc++.h>

using namespace std;


// } Driver Code Ends
//User function template for C++
class Solution{
public:	
	int findKRotation(int arr[], int n) {
	    // code here
	    if(arr[n-1]<arr[0]){
	      return searchKthRotation(arr, n);
	    }
	    return 0;
	} 
	
	int searchKthRotation(int arr[], int n){
	    int l = 0;
	    int r = n-1;
	    while(l<=r){
	        int mid = l + ((r-l)/2);
	        if(arr[mid+1]<arr[mid]){
	            return mid+1;
	        } else if(arr[mid]<arr[0]){
	            r = mid-1;
	        } else if(arr[n-1]<arr[mid]){
	            l = mid+1;
	        }
	    }
	    return 0;
	}

};

//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        int n, i;
        cin >> n;
        int a[n];
        for (i = 0; i < n; i++) {
            cin >> a[i];
        }
        Solution ob;
        auto ans = ob.findKRotation(a, n);
        cout << ans << "\n";
    }
    return 0;
}

// } Driver Code Ends