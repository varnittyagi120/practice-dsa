package src.graphlatest;

import java.util.ArrayList;
import java.util.Arrays;

//using DFS
//TC : O(V+2E)
//SC : O(V)
public class CheckBipartiteGraph {
        public boolean isBipartite(int V, int[][] edges) {
            int[] color = new int[V];
            ArrayList<ArrayList<Integer>> adj = getAdjacentList(V, edges);
            Arrays.fill(color, -1);

            for(int i=0;i<V;i++){
                if(color[i]==-1){
                    if(checkBipartiteGraph(i, 0, color, adj)==false){
                        return false;
                    }
                }
            }

            return true;

        }

        private boolean checkBipartiteGraph(int start, int col, int[] color, ArrayList<ArrayList<Integer>> adj){
            color[start] = col;
            for(int element : adj.get(start)){
                if(color[element]==-1){
                    color[element] = color[start]==0?1:0;
                    if(!checkBipartiteGraph(element, color[element], color, adj)){
                        return false;
                    }
                } else if(color[start]==color[element]){
                    return false;
                }
            }
            return true;
        }


        private ArrayList<ArrayList<Integer>> getAdjacentList(int V, int[][] edges){
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for(int i=0;i<V;i++){
                adj.add(new ArrayList<>());
            }
            for(int[] edge:edges){
                adj.get(edge[0]).add(edge[1]);
                adj.get(edge[1]).add(edge[0]);
            }
            return adj;
        }
}
