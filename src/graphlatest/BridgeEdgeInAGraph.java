package src.graphlatest;

import java.util.ArrayList;
import java.util.Arrays;

// time complexity O(V+2*E)
// space complexity O(v+2E) + O(3*V)
public class BridgeEdgeInAGraph {
        int t = 1;
        public boolean isBridge(int V, int[][] edges, int c, int d) {
            // code here
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for(int i=0;i<V;i++){
                adj.add(new ArrayList<>());
            }
            for(int[] edge : edges){
                adj.get(edge[0]).add(edge[1]);
                adj.get(edge[1]).add(edge[0]);
            }

            boolean[] visit = new boolean[V];
            Arrays.fill(visit, false);
            int[] low = new int[V];
            int[] tin = new int[V];
            boolean[] result = new boolean[1];
            result[0] = false;
            for(int i=0;i<V;i++){
                findBridges(i, -1, adj, visit, low, tin, result, c, d);
            }
            return result[0];
        }

        private void findBridges(int node, int parent, ArrayList<ArrayList<Integer>> adj, boolean[] visit, int[] low, int[] tin, boolean[] result, int c, int d){
            visit[node] = true;
            low[node] = tin[node] = t;
            t++;
            for(int element : adj.get(node)){
                if(element == parent){
                    continue;
                }

                if(!visit[element]){
                    findBridges(element, node, adj, visit, low, tin, result, c, d);
                    low[node] = Math.min(low[node], low[element]);
                    if(low[element] > tin[node]){
                        if((c==node && d==element) || (c==element && d==node)){
                            result[0] = true;
                        }
                    }
                } else {
                    low[node] = Math.min(low[node], low[element]);

                }
            }
        }
}
