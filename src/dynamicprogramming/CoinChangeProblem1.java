package src.dynamicprogramming;

public class CoinChangeProblem1 {
        public int count(int coins[], int sum) {
            int row = coins.length+1;
            int col = sum+1;
            int[][] dp = initilizeArray(row, col);
            dp = findNumberOfWays(dp, row, col, coins);
            return dp[row-1][col-1];
        }

        private int[][] findNumberOfWays(int[][] dp, int row, int col, int[] coins){
            for(int i=1;i<row;i++){
                for(int j=0;j<col;j++){
                    if(coins[i-1]<=j){
                        dp[i][j] = dp[i-1][j]+dp[i][j-coins[i-1]];
                    } else {
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
            return dp;
        }

        private int[][] initilizeArray(int row, int col){
            int[][] dp = new int[row][col];
            for(int i=0;i<row;i++){
                for(int j=0;j<col;j++){
                    if(i==0){
                        dp[i][j] = 0;
                    }

                    if(j==0){
                        dp[i][j] = 1;
                    }
                }
            }
            return dp;
        }
}

// time and both space complexities are O(n*sum)
