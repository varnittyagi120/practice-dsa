package src;

import java.util.Arrays;

public class SetMatrixZeros {
        public void setZeroes(int[][] matrix) {
            int row = matrix.length;
            int col = matrix[0].length;
            int[] a = new int[row];
            int[] b = new int[col];
            Arrays.fill(a, 0);
            Arrays.fill(b, 0);
            for(int i=0;i<row;i++){
                for(int j=0;j<col;j++){
                    if(matrix[i][j]==0){
                        a[i] = 1;
                        b[j] = 1;
                    }
                }
            }

            for(int i=0;i<row;i++){
                for(int j=0;j<col;j++){
                    if(a[i]!=0 || b[j]!=0){
                        matrix[i][j] = 0;
                    }
                }
            }
        }
}
