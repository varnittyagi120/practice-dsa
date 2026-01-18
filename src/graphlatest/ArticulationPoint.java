package src.graphlatest;

import java.util.ArrayList;
import java.util.Arrays;
// time complexity O(V+2E) + O(V)
// space complexity O(4*V)
public class ArticulationPoint {
        static int timer = 0;
        static ArrayList<Integer> articulationPoints(int V, int[][] edges) {
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
            boolean[] mark = new boolean[V];
            Arrays.fill(visit, false);
            Arrays.fill(mark, false);
            int[] low = new int[V];
            int[] tin = new int[V];
            Arrays.fill(mark, false);
            for(int i=0;i<V;i++){
                if(!visit[i]){
                    findArticulationPoint(i, -1, adj, visit, low, tin, mark);
                }
            }

            ArrayList<Integer> result = new ArrayList<>();
            for(int i=0;i<V;i++){
                if(mark[i]){
                    result.add(i);
                }
            }
            if(result.size()==0){
                result.add(-1);
                return result;
            }
            return result;
        }

        private static void findArticulationPoint(int node, int parent, ArrayList<ArrayList<Integer>> adj, boolean[] visit, int[] low, int[] tin, boolean[] mark){
            visit[node] = true;
            low[node] = tin[node] = timer;
            timer++;
            int count = 0;
            for(Integer element : adj.get(node)){
                if(element == parent){
                    continue;
                }
                if(!visit[element]){
                    findArticulationPoint(element, node, adj, visit, low, tin, mark);
                    low[node] = Math.min(low[node], low[element]);
                    if(low[element]>=tin[node] && parent != -1){
                        mark[node] = true;
                    }
                    count++;

                } else {
                    low[node] = Math.min(low[node], low[element]);
                }
            }

            if(count>1 && parent == -1){
                mark[node] = true;
            }
        }
}
