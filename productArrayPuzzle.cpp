//{ Driver Code Starts
//Initial template for C++

#include<bits/stdc++.h>
using namespace std;



// } Driver Code Ends
//User function template for C++

class Solution{
  public:
    // nums: given vector
    // return the Product vector P that hold product except self at each index
    vector<long long int> productExceptSelf(vector<long long int>& nums, int n) {
       
        long long int multipleOfAllTheProducts = 1;
        bool zeroOccurred = false;
        int countOfZero = 0;
        for(int i=0;i<n;i++){
            if(nums[i]!=0){
              multipleOfAllTheProducts = multipleOfAllTheProducts*nums[i];   
            }
            if(nums[i]==0){
                zeroOccurred = true;
                countOfZero++;
            }
        }
        
        vector<long long int> result;
        for(int i=0;i<n;i++){
            if(countOfZero>1){
             result.push_back(0);   
            } else {
             if(zeroOccurred && nums[i]!=0){
                result.push_back(0);
             } else if(zeroOccurred && nums[i]==0) {
               result.push_back(multipleOfAllTheProducts);
             } else if(!zeroOccurred){
                 result.push_back(multipleOfAllTheProducts/nums[i]);
             }
            }
        }
        return result;
    }
};


//{ Driver Code Starts.
int main()
 {
    int t;  // number of test cases
    cin>>t;
    while(t--)
    {
        int n;  // size of the array
        cin>>n;
        vector<long long int> arr(n),vec(n);
        
        for(int i=0;i<n;i++)    // input the array
        {
            cin>>arr[i];
        }
        Solution obj;
        vec = obj.productExceptSelf(arr,n);   // function call
        
        for(int i=0;i<n;i++)    // print the output
        {
            cout << vec[i] << " ";
        }
        cout<<endl;
    }
	return 0;
}
// } Driver Code Ends