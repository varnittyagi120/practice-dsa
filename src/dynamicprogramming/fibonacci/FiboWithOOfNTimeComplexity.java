package src.dynamicprogramming.fibonacci;

public class FiboWithOOfNTimeComplexity {
        public int nthFibonacci(int n) {
            if(n==0 || n==1){
                return n;
            }
            int[] dp = new int[n+1];
            return fibo(n, dp);
        }

        private int fibo(int n, int[] dp) {
            dp[0] = 0;
            dp[1] = 1;
            for (int i = 2; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[n];
        }

//time complexity will be here O(n)
//space complexity will be here O(n)
//no stack time complexity
}
