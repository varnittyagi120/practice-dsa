package src.dynamicprogramming.fibonacci;

public class FindFibonacciNumber {
    public int nthFibonacci(int n) {
            if(n<=1){
                return n;
            }

            return nthFibonacci(n-1)+nthFibonacci(n-2);
    }
}
//the time complexity is here
//2^n
//we are making two function calls
//and further code is making two more calls