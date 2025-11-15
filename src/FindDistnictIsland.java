package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

// time complexity O(n*m)+O(n*m*4)
// space complexity O(n*m)
public class FindDistnictIsland {
    // User function Template for Java
        class Pair {
            int first;
            int second;
            Pair(int first, int second){
                this.first = first;
                this.second = second;
            }

            public int getFirst(){
                return this.first;
            }

            public int getSecond(){
                return this.second;
            }
        }
        int countDistinctIslands(int[][] grid) {
            // Your Code here
            int n = grid.length;
            int m = grid[0].length;

            boolean[][] visit = new boolean[n][m];

            for(boolean[] row : visit){
                Arrays.fill(row, false);
            }

            HashSet<ArrayList<String>> set = new HashSet<>();
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(grid[i][j]==1 && !visit[i][j]){
                        ArrayList<String> vec = new ArrayList<>();
                        dfs(i, j, vec, visit, grid, i, j);
                        set.add(vec);
                    }
                }
            }
            return set.size();
        }

        private void dfs(int row, int col, ArrayList<String> vec, boolean[][] visit, int[][] grid, int rowBase, int colBase){
            visit[row][col] = true;
            int n = grid.length;
            int m = grid[0].length;
            vec.add(toString(row-rowBase, col-colBase));
            int[] delRow = {-1, 0, +1, 0};
            int[] delCol = {0, -1, 0, +1};
            for(int i=0;i<4;i++){
                int newRow = row + delRow[i];
                int newCol = col + delCol[i];
                if(newRow>=0 && newRow<n && (newCol>=0 && newCol<m) && !visit[newRow][newCol] &&
                        grid[newRow][newCol]==1){
                    dfs(newRow, newCol, vec, visit, grid, rowBase, colBase);
                }
            }
        }

        private String toString(int row, int col){
            return Integer.toString(row)+" "+Integer.toString(col);
        }
}
