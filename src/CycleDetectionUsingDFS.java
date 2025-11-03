package src;

import java.util.ArrayList;
import java.util.Arrays;

public class CycleDetectionUsingDFS {
        public boolean isCycle(int V, int[][] edges) {
            boolean[] visit = new boolean[V];
            Arrays.fill(visit, false);
            ArrayList<ArrayList<Integer>> adj = getAdjList(V, edges);
            for(int i=0;i<V;i++){
                if(!visit[i]){
                    if(checkIsCycle(i, -1, visit, adj)){
                        return true;
                    }
                }
            }
            return false;
        }

        private ArrayList<ArrayList<Integer>> getAdjList(int V,int[][] edges){
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

        private boolean checkIsCycle(int index, int parent,boolean[] visit, ArrayList<ArrayList<Integer>> adj) {
            visit[index] = true;
            ArrayList<Integer> list = adj.get(index);
            for (int element : list) {
                if (!visit[element]) {
                    if (checkIsCycle(element, index, visit, adj)) {
                        return true;
                    }
                } else if (element != parent) {
                    return true;
                }
            }
            return false;
        }

}
