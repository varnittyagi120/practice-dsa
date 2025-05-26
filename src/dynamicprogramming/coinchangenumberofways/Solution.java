package src.dynamicprogramming.coinchangenumberofways;

public class Solution {
    public int count(int coins[], int sum) {
        // code here.
        int n = coins.length+1;
        int w = sum+1;
        int t[][] = new int[n][w];
        for(int i=0;i<n;i++){
            for(int j=0;j<w;j++){
                if(i==0){
                    t[i][j] = 0;
                }

                if(j==0){
                    t[i][j] = 1;
                }
            }
        }

        for(int i=1;i<n;i++){
            for(int j=1;j<w;j++){
                if(coins[i-1]<=j){
                    t[i][j] = (t[i][j-coins[i-1]]+t[i-1][j]);
                } else {
                    t[i][j] = t[i-1][j];
                }
            }
        }

        return t[coins.length][sum];
    }
}
