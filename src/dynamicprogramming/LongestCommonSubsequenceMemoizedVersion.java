package src.dynamicprogramming;

public class LongestCommonSubsequenceMemoizedVersion {
        public int longestCommonSubsequence(String text1, String text2) {
            int m = text1.length();
            int n = text2.length();
            int[][] dp = new int[m+1][n+1];
            for(int i=0;i<m+1;i++){
                for(int j=0;j<n+1;j++){
                    dp[i][j] = -1;
                }
            }
            lcs(text1, text2, text1.length(), text2.length(), dp);
            return dp[m][n];
        }

        private int lcs(String x, String y, int m, int n, int[][] dp){
            if(m==0 || n==0){
                return 0;
            }
            if(dp[m][n]!=-1){
                return dp[m][n];
            }

            if(x.charAt(m-1)==y.charAt(n-1)){
                return dp[m][n] = 1+lcs(x,y,m-1,n-1, dp);
            }
            return dp[m][n] = Math.max(lcs(x, y, m, n-1, dp), lcs(x, y, m-1, n, dp));
        }
}


// time complexity O(m*n)
// space complexity O(m*n)
// time is the memoized solution