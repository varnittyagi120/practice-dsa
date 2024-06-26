//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution{
    public:
    vector<pair<int,int>> allPairs(int A[], int B[], int N, int M, int X)
    {
    
        vector<pair<int, int>> result;
        sort(A, A+N);
        sort(B, B+M);
        for(int i=0;i<N;i++){
            int difference = X-A[i];
            int findValue = binarySearch(B, M, difference);
            if(findValue != INT_MIN) {
                result.push_back(make_pair(A[i], findValue));
            }
        }
        return result;
    }
    
    int binarySearch(int B[], int M, int X){
        int l = 0;
        int r = M-1;
        while(l<=r){
            int mid = (r+l)/2;
            if(B[mid]==X){
                return X;
            } else if(B[mid]<X){
                l = mid+1;
            } else {
                r=mid-1;
            }
            
        }
        return INT_MIN;
    }
};


//{ Driver Code Starts.
int main() {
	long long t;
	cin >> t;
	
	while(t--){
	    int N, M, X;
	    cin >> N >> M >> X;
        int A[N], B[M];
        
	    for(int i = 0;i<N;i++)
	        cin >> A[i];
	    for(int i = 0;i<M;i++)
	        cin >> B[i];
	        
	   Solution ob;
	   vector<pair<int,int>> vp = ob.allPairs(A, B, N, M, X);
	   int sz = vp.size();
        if(sz==0)
        cout<<-1<<endl;
        else{
            for(int i=0;i<sz;i++){
                if(i==0)
                cout<<vp[i].first<<" "<<vp[i].second;
                else
                cout<<", "<<vp[i].first<<" "<<vp[i].second;
            }
            cout<<endl;
        }
	}
	return 0;
}
// } Driver Code Ends