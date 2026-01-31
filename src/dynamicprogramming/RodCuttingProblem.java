package src.dynamicprogramming;

public class RodCuttingProblem {
        public int cutRod(int[] price) {
            // code here
            int size = price.length;
            int[] length = new int[size];
            for(int i=0;i<size;i++){
                length[i] = i+1;
            }

            return findMaximumProfit(price, length);
        }

        private int findMaximumProfit(int[] price, int[] length){
            int row = price.length+1;
            int col = row;
            int[][] dp = new int[row][col];
            for(int i=0;i<row;i++){
                for(int j=0;j<col;j++){
                    if(i==0 || j==0){
                        dp[i][j] = 0;
                    }
                }
            }

            for(int i=1;i<row;i++){
                for(int j=0;j<col;j++){
                    if(length[i-1]<=j){
                        dp[i][j] = Math.max(price[i-1]+dp[i][j-length[i-1]],
                                dp[i-1][j]);
                    } else {
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
            return dp[row-1][col-1];
        }
}
