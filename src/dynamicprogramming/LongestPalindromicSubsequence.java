package src.dynamicprogramming;

public class LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String s) {
        int m = s.length();
        int[][] dp = new int[m+1][m+1];
        for(int i=0;i<m+1;i++){
            for(int j=0;j<m+1;j++){
                if(i==0 || j==0){
                    dp[i][j] = 0;
                }
            }
        }
        StringBuilder str = new StringBuilder(s);
        str.reverse();
        for(int i=1;i<m+1;i++){
            for(int j=1;j<m+1;j++){
                if(s.charAt(i-1)==str.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        return dp[m][m];
    }
}
