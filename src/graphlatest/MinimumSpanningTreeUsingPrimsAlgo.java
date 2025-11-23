package src.graphlatest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
//time comp O(E*logE)
//space O(E)
public class MinimumSpanningTreeUsingPrimsAlgo {
        class Pair{
            int node;
            int distance;
            Pair(int node, int distance){
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

        class PairTwo{
            int node;
            int wt;
            PairTwo(int node, int wt){
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
        public int spanningTree(int V, int[][] edges) {
            // code here
            int sum = 0;
            int[] visit = new int[V];
            ArrayList<ArrayList<PairTwo>> adj = getAdjList(V, edges);
            PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y)->x.distance-y.distance);
            Arrays.fill(visit, 0);
            pq.add(new Pair(0, 0));
            while(!pq.isEmpty()){
                Pair pair = pq.peek();
                pq.remove();
                int element = pair.getNode();
                int dt = pair.getDistance();
                if(visit[element]==1){
                    continue;
                }
                visit[element] = 1;
                sum+=dt;
                for(PairTwo pairTwo : adj.get(element)){
                    int node = pairTwo.getNode();
                    int wt = pairTwo.getWeight();
                    if(visit[node]==0){
                        pq.add(new Pair(node, wt));
                    }
                }
            }
            return sum;
        }

        private ArrayList<ArrayList<PairTwo>> getAdjList(int V, int[][] edges){
            ArrayList<ArrayList<PairTwo>> adj = new ArrayList<>();
            for(int i=0;i<V;i++){
                adj.add(new ArrayList<>());
            }

            for(int[] edge : edges){
                int u = edge[0];
                int v = edge[1];
                int wt = edge[2];
                adj.get(u).add(new PairTwo(v, wt));
                adj.get(v).add(new PairTwo(u, wt));
            }
            return adj;
        }
}
