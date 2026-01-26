package src.dynamicprogramming;

public class SubsetSumPartition {
        static boolean equalPartition(int arr[]) {
            // code here
            int sum = 0;
            for(int i=0;i<arr.length;i++){
                sum += arr[i];
            }
            if(sum%2 != 0){
                return false;
            }

            sum = sum/2;
            return subsetSum(arr, sum);
        }

        private static boolean subsetSum(int[] arr, int sum){
            int row = arr.length;
            int col = sum;
            boolean[][] t = new boolean[row+1][col+1];
            for(int i=0;i<row+1;i++){
                for(int j=0;j<col+1;j++){
                    if(i==0){
                        t[i][j] = false;
                    }
                    if(j==0){
                        t[i][j] = true;
                    }
                }
            }

            for(int i=1;i<row+1;i++){
                for(int j=1;j<col+1;j++){
                    if(arr[i-1]<=j){
                        t[i][j] = t[i-1][j-arr[i-1]] || t[i-1][j];
                    } else {
                        t[i][j] = t[i-1][j];
                    }
                }
            }
            return t[row][col];
        }
}

//time complexity O(n*sum/2)
//space complexity O(n*sum/2)
