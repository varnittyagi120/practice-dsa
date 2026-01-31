package src.dynamicprogramming;

public class CoinChangeProblemII {
        public int minCoins(int coins[], int sum) {
            // code here
            int row = coins.length+1;
            int col = sum+1;
            int max = Integer.MAX_VALUE-1;
            int[][] dp = new int[row][col];
            for(int i=0;i<row;i++){
                for(int j=0;j<col;j++){
                    if(i==0){
                        dp[i][j] = max;
                    }

                    if(j==0){
                        dp[i][j] = 0;
                    }
                }
            }
            int t=1;
            for(int k=1;k<col;k++){
                if(k%coins[0]==0){
                    dp[t][k] = k/coins[0];
                } else {
                    dp[t][k] = max;
                }
            }

            for(int i=2;i<row;i++){
                for(int j=1;j<col;j++){
                    if(coins[i-1]<=j){
                        dp[i][j] = Math.min(1+dp[i][j-coins[i-1]], dp[i-1][j]);
                    } else {
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
            return (dp[row-1][col-1]==max)?-1:dp[row-1][col-1];
        }
}


//time and space complexity O(n*sum)