package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// time complexity O(n!)
// space complexity O(n^2)
public class NQueensProblem {
        public List<List<String>> solveNQueens(int n) {
            List<List<String>> result = new ArrayList<>();
            char[][] board = new char[n][n];
            for(char[] row:board){
                Arrays.fill(row, '.');
            }
            int[] leftRow = new int[n];
            int[] upperDiag =  new int[2*n-1];
            int[] lowerDiag =  new int[2*n-1];
            solve(0, n, board, leftRow, upperDiag, lowerDiag, result);
            return result;
        }

        private void solve(int col, int n, char[][] board, int[] leftRow, int[] upperDiag, int[] lowerDiag, List<List<String>> result) {
            if (col == n) {
                List<String> temp = new ArrayList<>();
                for (char[] row : board) {
                    temp.add(new String(row));
                }
                result.add(temp);
                return;
            }

            for (int row = 0; row < n; row++) {
                if (leftRow[row] == 0 && upperDiag[n - 1 + (col - row)] == 0 && lowerDiag[col + row] == 0) {
                    board[row][col] = 'Q';
                    leftRow[row] = 1;
                    upperDiag[n - 1 + col - row] = 1;
                    lowerDiag[row + col] = 1;
                    solve(col + 1, n, board, leftRow, upperDiag, lowerDiag, result);
                    board[row][col] = '.';
                    leftRow[row] = 0;
                    upperDiag[n - 1 + col - row] = 0;
                    lowerDiag[row + col] = 0;
                }
            }
        }
}
