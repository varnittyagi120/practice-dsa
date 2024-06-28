//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

int findElement(int arr[], int n);

int main() {
    int t;
    cin >> t;
    while (t--) {
        int n, i;
        cin >> n;
        int a[n];
        for (i = 0; i < n; i++) cin >> a[i];
        cout << findElement(a, n) << endl;
    }
    return 0;
}

// } Driver Code Ends




int findElement(int arr[], int n) {
    int max = INT_MIN;
    int temp = -1;
    int index = -1;
    for(int i=0;i<n;i++){
        if(i==0){
            max = arr[i];
            temp = -1;
        } else {
            if(max<=arr[i]){
                max = arr[i];
                if(temp==-1){
                    temp=max;
                    index = i;
                }
            }
            if(arr[i]<max && temp!=arr[i]){
                temp = -1;
            }
        }
    }
    if(index!=n-1 && temp!=-1){
        return temp;
    }
    return -1;
}