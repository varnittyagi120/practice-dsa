package src.graphlatest;

import java.util.ArrayList;
import java.util.Arrays;

// Time Complexity O(V+E)
//Space complexity will be O(V)
public class DetectCycleInDirectedGraph {
        public boolean isCyclic(int V, int[][] edges) {
            // code here
            ArrayList<ArrayList<Integer>> adj = getAdjList(V, edges);
            int[] visit = new int[V];
            int[] pathVisit = new int[V];
            Arrays.fill(visit, 0);
            Arrays.fill(pathVisit, 0);
            for(int i=0;i<V;i++){
                if(visit[i]==0){
                    if(isCycleDetected(i, visit, pathVisit, adj)){
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean isCycleDetected(int start, int[] visit, int[] pathVisit, ArrayList<ArrayList<Integer>> adj){
            visit[start] = 1;
            pathVisit[start] = 1;
            for(int element : adj.get(start)){
                if(visit[element]==0){
                    if(isCycleDetected(element, visit, pathVisit, adj)){
                        return true;
                    }
                } else if(pathVisit[element]==1){
                    return true;
                }
            }
            pathVisit[start] = 0;
            return false;
        }

        private ArrayList<ArrayList<Integer>> getAdjList(int V, int[][] edges){
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for(int i=0;i<V;i++){
                adj.add(new ArrayList<>());
            }

            for(int[] edge:edges){
                adj.get(edge[0]).add(edge[1]);
            }
            return adj;
        }
}
