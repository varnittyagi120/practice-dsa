package src;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// space complexity O(n^2) + O(n^2)
// time complexity  O(n^2) + O(n^2)*9
public class NumberOfLands {
        public class Pair{
            int row;
            int col;
            Pair(int row, int col){
                this.row = row;
                this.col = col;
            }

            public int getRow(){
                return this.row;
            }

            public int getCol(){
                return this.col;
            }
        }
        public int countIslands(char[][] grid) {
            // Code here
            int row = grid.length;
            int col = grid[0].length;
            boolean[][] visit = new boolean[row][col];
            for(boolean[] rows:visit){
                Arrays.fill(rows, false);
            }
            int count = 0;
            for(int i = 0;i<row;i++){
                for(int j=0;j<col;j++){
                    if(!visit[i][j] && grid[i][j]=='L'){
                        bfs(i, j, visit, grid);
                        count++;
                    }
                }
            }

            return count;
        }

        private void bfs(int i, int j, boolean[][] visit, char[][] grid){
            visit[i][j] = true;
            Pair pair = new Pair(i,j);
            Queue<Pair> queue = new LinkedList<>();
            queue.add(pair);

            while(!queue.isEmpty()){
                Pair pair1 = queue.poll();
                int row = pair1.getRow();
                int col = pair1.getCol();

                for(int delr = -1;delr<=1;delr++){
                    for(int delc = -1;delc<=1;delc++){
                        int newRow = delr+row;
                        int newCol = delc+col;
                        if(newRow>=0 && newRow<grid.length
                                && newCol>=0 && newCol<grid[0].length
                                && !visit[newRow][newCol] && grid[newRow][newCol]=='L'){
                            queue.add(new Pair(newRow, newCol));
                            visit[newRow][newCol] = true;
                        }
                    }
                }
            }
        }
}
