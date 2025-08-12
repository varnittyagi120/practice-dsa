package src.kthsmallestelementInsortedmatrix;

public class KthSmallestElementInSortedMatrix {
        public int kthSmallest(int[][] matrix, int k) {
            int n = matrix.length;
            int start = matrix[0][0];
            int end = matrix[n-1][n-1];
            while(start<end){
                int mid = start + (end-start)/2;
                int count = 0;
                for(int i=0;i<n;i++){
                    count += findCountLessThanMid(matrix, mid, i);
                }
                if(count<k){
                    start = mid+1;
                } else {
                    end = mid;
                }
            }
            return start;
        }

        private int findCountLessThanMid(int[][] matrix, int mid1, int i){
            int start = 0;
            int end = matrix.length;
            while(start<end){
                int mid = start+(end-start)/2;
                if(matrix[i][mid] <= mid1){
                    start = mid+1;
                } else {
                    end = mid;
                }
            }
            return start;
        }
}
