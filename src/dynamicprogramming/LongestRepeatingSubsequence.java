package src.dynamicprogramming;

public class LongestRepeatingSubsequence {
    // User function Template for Java
     public int LongestRepeatingSubsequence(String s) {
            // code here
            String tempString = s;
            int m = s.length();
            int[][] dp = new int[m+1][m+1];
            for(int i=0;i<m+1;i++){
                for(int j=0;j<m+1;j++){
                    if(i==0 || j==0){
                        dp[i][j] = 0;
                    }
                }
            }

            for(int i=1;i<m+1;i++){
                for(int j=1;j<m+1;j++){
                    if(s.charAt(i-1)==tempString.charAt(j-1) && i!=j){
                        dp[i][j] = dp[i-1][j-1]+1;
                    } else {
                        dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                    }
                }
            }
            return dp[m][m];
        }
}
