package src.dynamicprogramming;

import java.util.Arrays;

public class MatrixChainMultiplication {
        static int[][] t = new int[1001][1001];
        static int matrixMultiplication(int arr[]) {
            for(int i=0;i<1001;i++){
                Arrays.fill(t[i], -1);
            }
            // code here
            return solve(arr, 1, arr.length-1);

        }

        private static int solve(int arr[], int i, int j){
            if(i>=j){
                return 0;
            }

            if(t[i][j]!=-1){
                return t[i][j];
            }
            int min = Integer.MAX_VALUE;
            int temp = 0;
            for(int k=i;k<j;k++){
                temp = solve(arr, i, k)+solve(arr, k+1, j)+arr[i-1]*arr[j]*arr[k];
                if(temp<min){
                    min = temp;
                }
            }
            return t[i][j] = min;
        }

//time complexity O(n^3)
//space complexity O(n^2)
//recursion stack depth O(n)
}
