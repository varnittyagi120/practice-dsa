package src.graphlatest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

//time complexity O((V+E)*log(V))
//space complexity O(V+E)
public class DijkstraAlgorithmUsingPriorityQueue {
        class Pair {
            int node;
            int wt;
            Pair(int node, int wt){
                this.node = node;
                this.wt = wt;
            }

            public int getNode(){
                return this.node;
            }

            public int getWeight(){
                return this.wt;
            }
        }

        class PairTwo{
            int node;
            int distance;
            PairTwo(int node, int distance){
                this.node = node;
                this.distance = distance;
            }

            public int getNode(){
                return this.node;
            }

            public int getDistance(){
                return this.distance;
            }
        }

        public int[] dijkstra(int V, int[][] edges, int src) {
            ArrayList<ArrayList<Pair>> adj = getAdjList(V, edges);
            int[] dist = new int[V];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[src] = 0;
            PriorityQueue<PairTwo> pq = new PriorityQueue<PairTwo>((x, y)->x.distance-y.distance);
            pq.add(new PairTwo(src, 0));

            while(!pq.isEmpty()){
                PairTwo pair = pq.peek();
                pq.remove();
                int node = pair.getNode();
                int dt = pair.getDistance();
                if(dist[node]==Integer.MAX_VALUE){
                    continue;
                }
                for(Pair pr : adj.get(node)){
                    if(pr.getWeight()+dt < dist[pr.getNode()]){
                        dist[pr.getNode()] = pr.getWeight()+dt;
                        pq.add(new PairTwo(pr.getNode(), dist[pr.getNode()]));
                    }
                }
            }
            return dist;
        }

        private ArrayList<ArrayList<Pair>> getAdjList(int V, int[][] edges){
            ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
            for(int i=0;i<V;i++){
                adj.add(new ArrayList<>());
            }

            for(int[] edge : edges){
                int u = edge[0];
                int v = edge[1];
                int wt = edge[2];
                adj.get(u).add(new Pair(v, wt));
                adj.get(v).add(new Pair(u, wt));
            }
            return adj;
        }
}
