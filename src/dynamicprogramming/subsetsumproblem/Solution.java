package src.dynamicprogramming.subsetsumproblem;

public class Solution {
    static Boolean isSubsetSum(int arr[], int sum) {
        int n = arr.length+1;
        int m = sum+1;
        boolean[][] t = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0){
                    t[i][j] = false;
                }
                if(j==0){
                    t[i][j] = true;
                }
            }
        }

        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(arr[i-1]<=j){
                    t[i][j] = (t[i-1][j-arr[i-1]] || t[i-1][j]);
                } else {
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[arr.length][sum];

    }
}
