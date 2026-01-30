package src.dynamicprogramming;

public class PartitionsWithGivenDifference {
        public int countPartitions(int[] arr, int diff) {
            // code here
            int zerosCount = 0;
            for(int i=0;i<arr.length;i++){
                if(arr[i]==0){
                    zerosCount++;
                }
            }
            int sumOfArray = getArraySum(arr);
            if(diff>sumOfArray || (sumOfArray+diff)%2!=0){
                return 0;
            }
            int sumToIdentify = (sumOfArray + diff)/2;
            int[] nonZeroElements = new int[arr.length-zerosCount];
            int k = 0 ;
            for(int i=0;i<arr.length;i++){
                if(arr[i]!=0){
                    nonZeroElements[k] = arr[i];
                    k++;
                }
            }
            return findPartitions(arr, sumToIdentify);
        }

        private int getArraySum(int[] arr){
            int sum = 0;
            for(int i=0;i<arr.length;i++){
                sum += arr[i];
            }
            return sum;
        }

        private int findPartitions(int[] arr, int sum){
            int row = arr.length+1;
            int col = sum+1;
            int[][] dp = new int[row][col];
            dp[0][0] = 1;

            for(int i=1;i<row;i++){
                for(int j=0;j<col;j++){
                    if(arr[i-1]<=j){
                        dp[i][j] = dp[i-1][j-arr[i-1]]+dp[i-1][j];
                    } else {
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
            return dp[row-1][col-1];
        }

}
