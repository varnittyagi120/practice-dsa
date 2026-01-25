package src.dynamicprogramming.fibonacci;

public class MostOptimizedFibonacciSeries {
        public int nthFibonacci(int n) {
            if(n==0 || n==1){
                return n;
            }
            return fibo(n);
        }

        private int fibo(int n) {
            int prev2 = 0;
            int prev = 1;
            int result = 0;
            for(int i=2;i<=n;i++){
                result = prev+prev2;
                prev2 = prev;
                prev = result;
            }
            return result;
        }

//time complexity will be here O(n)
//space complexity will be here O(n)
//no stack time complexity
}
