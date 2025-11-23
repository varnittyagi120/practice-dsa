package src.graphlatest;

import java.util.Arrays;

// time complexity O(V*E)
//space complexity O(V)
public class BellmanFordAlgorithmToFindShortestDistance {
    // User function Template for Java

        public int[] bellmanFord(int V, int[][] edges, int src) {
            int INF = (int)1e8;
            // code here
            int[] dist = new int[V];
            Arrays.fill(dist, INF);
            dist[src] = 0;
            for(int i=0;i<V-1;i++){
                for(int[] edge : edges){
                    int u = edge[0];
                    int v = edge[1];
                    int wt = edge[2];
                    if(dist[u]!=INF && dist[u]+wt < dist[v]){
                        dist[v] = dist[u]+wt;
                    }
                }
            }

            for(int[] edge: edges){
                int u = edge[0];
                int v = edge[1];
                int wt = edge[2];
                if(dist[u]!=INF && dist[u]+wt<dist[v]){
                    int[] temp = new int[1];
                    temp[0] = -1;
                    return temp;
                }
            }
            return dist;
        }
}
