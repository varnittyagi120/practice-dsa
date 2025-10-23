package src;

import java.util.LinkedList;
import java.util.Queue;

//time complexity O(m*n)
//space complexity [O(m*n) + O(m*n*4)]
public class RottingOranges {

        class Pair{
            int row;
            int col;
            int t;
            Pair(int row, int col, int t){
                this.row = row;
                this.col = col;
                this.t = t;
            }

            public int getRow(){
                return this.row;
            }

            public int getCol(){
                return this.col;
            }

            public int getTime(){
                return this.t;
            }
        }
        public int orangesRotting(int[][] grid) {
            int n = grid.length;
            int m = grid[0].length;

            int[][] visit = new int[n][m];
            Queue<Pair> q = new LinkedList<>();
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(grid[i][j]==2){
                        q.add(new Pair(i, j, 0));
                        visit[i][j] = 2;
                    }
                }
            }

            int[] drow = {-1, 0, 1, 0};
            int[] dcol = {0, 1, 0, -1};
            int result = 0;
            while(!q.isEmpty()){
                int row = q.peek().getRow();
                int col = q.peek().getCol();
                int t = q.peek().getTime();
                q.remove();
                result = Math.max(t, result);
                for(int i=0;i<4;i++){
                    int nrow = row+drow[i];
                    int ncol = col+dcol[i];
                    if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && visit[nrow][ncol]==0 && grid[nrow][ncol]==1){
                        visit[nrow][ncol] = 2;
                        q.add(new Pair(nrow, ncol, t+1));
                    }
                }

            }

            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(visit[i][j]!=2 && grid[i][j]==1){
                        return -1;
                    }
                }
            }
            return result;
        }
}
