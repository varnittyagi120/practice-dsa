package src.graphlatest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//time complexity O(V+2*E)
//space complexity  O(V+2*E)
public class ShortestPathInUndirectedGraphWithUnitWeights {
        public int[] shortestPath(int V, int[][] edges, int src) {
            // code here
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for(int i=0;i<V;i++){
                adj.add(new ArrayList<>());
            }

            for(int[] edge : edges){
                adj.get(edge[0]).add(edge[1]);
                adj.get(edge[1]).add(edge[0]);
            }

            int[] dist = new int[V];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[src] = 0;
            Queue<Integer> queue = new LinkedList<>();
            queue.add(src);
            while(!queue.isEmpty()){
                int node = queue.peek();
                queue.remove();
                if(dist[node]==Integer.MAX_VALUE){
                    continue;
                }
                for(int element : adj.get(node)){
                    if(dist[node]+1<dist[element]){
                        dist[element] = dist[node]+1;
                        queue.add(element);
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

}
