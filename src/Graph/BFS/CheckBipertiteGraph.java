package src.Graph.BFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// time complexity O(n+2*E)
// space complexity O(n)

public class CheckBipertiteGraph {
        public boolean isBipartite(int V, int[][] edges) {
            // Code here
            int[] color = new int[V];
            Arrays.fill(color, -1);
            ArrayList<ArrayList<Integer>> adj =  getAdjList(V, edges);
            for(int i=0;i<V;i++){
                if(color[i]==-1){
                    if(checkBipertite(i, V, adj, color)==false){
                        return false;
                    }
                }
            }
            return true;
        }

        private boolean checkBipertite(int start, int V, ArrayList<ArrayList<Integer>> adj, int[] color){
            Queue<Integer> queue = new LinkedList<>();
            queue.add(start);
            color[start] = 0;
            while(!queue.isEmpty()){
                int topNode = queue.poll();
                for(int itr:adj.get(topNode)){
                    if(color[itr]==-1){
                        color[itr] = color[topNode]==0?1:0;
                        queue.add(itr);
                    } else {
                        if(color[itr] == color[topNode]){
                            return false;
                        }
                    }
                }
            }
            return true;
        }

        private ArrayList<ArrayList<Integer>> getAdjList(int V, int[][] edges){
            ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
            for(int i=0;i<V;i++){
                adj.add(new ArrayList<>());
            }

            for(int[] edge : edges){
                adj.get(edge[0]).add(edge[1]);
                adj.get(edge[1]).add(edge[0]);
            }

            return adj;
        }
}
