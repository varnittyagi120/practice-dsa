package src.dynamicprogramming;

public class LongestCommonSubstring {
        public int longCommSubstr(String s1, String s2) {
            // code here
            int m = s1.length();
            int n = s2.length();
            int[][] dp = new int[m+1][n+1];
            for(int i=0;i<m+1;i++){
                for(int j=0;j<n+1;j++){
                    if(i==0 || j==0){
                        dp[i][j] = 0;
                    }
                }
            }

            int maxLength = 0;
            for(int i=1;i<m+1;i++){
                for(int j=1;j<n+1;j++){
                    if(s1.charAt(i-1)==s2.charAt(j-1)){
                        dp[i][j] = dp[i-1][j-1]+1;
                        maxLength = Math.max(maxLength, dp[i][j]);
                    } else {
                        dp[i][j] = 0;
                    }
                }
            }
            return maxLength;
        }
}

// time and space complexity both are the O(m*n)