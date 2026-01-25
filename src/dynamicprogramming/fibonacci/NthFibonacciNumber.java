package src.dynamicprogramming.fibonacci;

import java.util.Arrays;

public class NthFibonacciNumber {
        public int nthFibonacci(int n) {
            int[] dp = new int[n+1];
            Arrays.fill(dp, -1);
            return fibo(n, dp);
        }

        private int fibo(int n, int[] dp) {
            if(n<=1){
                return n;
            }
            if(dp[n] != -1){
                return dp[n];
            }
            dp[n] = nthFibonacci(n-1)+nthFibonacci(n-2);
            return dp[n];
        }
}

//time complexity will be here O(n)
// space complexity will be O(n)+O(n) stack + dp array
