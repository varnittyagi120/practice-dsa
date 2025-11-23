package src.graphlatest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

//time complexity O(V+E)
//space complexity O(V+E)
public class ShortestPathInDirectedAcyclicGraph {
    // User function Template for Java

        class Pair{
            int node;
            int weight;
            Pair(int node, int weight){
                this.node = node;
                this.weight = weight;
            }

            public int getNode(){
                return this.node;
            }

            public int getWeight(){
                return this.weight;
            }
        }
        public int[] shortestPath(int V, int E, int[][] edges) {
            // Code here
            ArrayList<ArrayList<Pair>> adj = getAdjList(V, E, edges);
            Stack<Integer> stack = new Stack<>();
            int[] visit = new int[V];
            Arrays.fill(visit, 0);
            for(int i=0;i<V;i++){
                if(visit[i]==0){
                    topoSort(i, adj, visit, stack);
                }
            }

            //create distance array
            int[] dist = new int[V];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[0] = 0;
            while(!stack.isEmpty()){
                int element = stack.peek();
                stack.pop();
                if(dist[element]==Integer.MAX_VALUE){
                    continue;
                }
                for(Pair pair: adj.get(element)){
                    int u = pair.getNode();
                    int wt = pair.getWeight();
                    //System.out.println("sum "+dist[element]+wt);
                    if(dist[element]+wt<dist[u]){
                        dist[u] = dist[element]+wt;
                    }
                }
            }

            for(int i=0;i<V;i++){
                if(dist[i]==Integer.MAX_VALUE){
                    dist[i] = -1;
                }
            }
            return dist;
        }

        private void topoSort(int node, ArrayList<ArrayList<Pair>> adj, int[] visit, Stack<Integer> stack){
            visit[node] = 1;
            for(Pair pair : adj.get(node)){
                int element = pair.getNode();
                if(visit[element]==0){
                    topoSort(element, adj, visit,  stack);
                }
            }
            stack.add(node);
        }

        private ArrayList<ArrayList<Pair>> getAdjList(int V, int E, int[][] edges){
            ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
            for(int i=0;i<V;i++){
                adj.add(new ArrayList<>());
            }

            for(int i=0;i<E;i++){
                int u = edges[i][0];
                int v = edges[i][1];
                int wt = edges[i][2];
                adj.get(u).add(new Pair(v, wt));
            }
            return adj;
        }
}
