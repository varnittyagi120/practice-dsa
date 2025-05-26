package src.dynamicprogramming.coinchangebyselectingMinimumNumberOfCoins;

public class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length+1;
        int w = amount+1;
        int[][] t = new int[n][w];
        for(int i=0;i<n;i++){
            for(int j=0;j<w;j++){
                if(j==0){
                    t[i][j] = 0;
                }
                if(i==0){
                    t[i][j] = Integer.MAX_VALUE-1;
                }

                if(i==1){
                    if(j%coins[i-1]==0){
                        t[i][j] = j/coins[i-1];
                    } else{
                        t[i][j] = Integer.MAX_VALUE-1;
                    }
                }
            }
        }
        t[0][0]=0;

        for(int i=1;i<n;i++){
            for(int j=1;j<w;j++){
                if(coins[i-1]<=j){
                    t[i][j] = Math.min(1+t[i][j-coins[i-1]], t[i-1][j]);
                } else{
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[coins.length][amount]==Integer.MAX_VALUE-1?-1:t[coins.length][amount];
    }
}
