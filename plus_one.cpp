//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
//User function Template for C++

class Solution {
  public:
    vector<int> increment(vector<int> arr ,int N) {
        int carry = 1;
        bool addingPlusOneOnce = true;
        for(int i=arr.size()-1;i>=0;i--){
            int temp = arr[i]+carry;
            if(temp==10){
                arr[i] = 0;
                carry = 1;
            } else {
                arr[i] = temp;
                carry = 0;
            }
        }
        if(carry==1){
            arr.insert(arr.begin(), 1, carry);
        
        }
        return arr;
    }
};

//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        int N;
        char c;
        
        cin>>N;
        vector<int> arr(N);
        
        for(int i=0 ; i<N ; i++)
            cin>>arr[i];

        Solution ob;
        vector<int> res = ob.increment(arr,N);
        for(int i: res)
            cout<<i<<" ";
        cout<<endl;
    }
    return 0;
}
// } Driver Code Ends