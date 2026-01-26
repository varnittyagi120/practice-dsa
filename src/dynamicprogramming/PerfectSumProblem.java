package src.dynamicprogramming;

public class PerfectSumProblem {
    //class Solution {
        // Function to calculate the number of subsets with a given sum
        public int perfectSum(int[] nums, int target) {
            // code here
            int row = nums.length+1;
            int col = target+1;
            int[][] dp = new int[row][col];
            dp[0][0] = 1;

            for(int i=1;i<row;i++){
                for(int j=0;j<col;j++){
                    if(nums[i-1]<=j){
                        dp[i][j] = dp[i-1][j] + dp[i-1][j-nums[i-1]];
                    } else {
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
            return dp[row-1][col-1];
        }
    //}
}

//time complexity O(n*target)
//space complexity O(n*target)
