package src.Graph.BFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//time complexity O(n+2*E) + O(N)
//space complexity O(N)+O(N)  queue + visited array
public class UndirectedGraphCycle {
        class Pair{
            int node;
            int parent;
            Pair(int node, int parent){
                this.node = node;
                this.parent = parent;
            }

            public int getNode(){
                return this.node;
            }

            public int getParent(){
                return this.parent;
            }
        }

        public boolean isCycle(int V, int[][] edges) {
            boolean[] visit = new boolean[V];
            Arrays.fill(visit, false);
            ArrayList<ArrayList<Integer>> adj = getAdjList(V, edges);
            for(int i=0;i<V;i++){
                if(!visit[i]){
                    if(checkIsCycle(i, visit, adj)){
                        return true;
                    }
                }
            }
            return false;
        }

        private ArrayList<ArrayList<Integer>> getAdjList(int V, int[][] edges){
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

        private boolean checkIsCycle(int index,boolean[] visit, ArrayList<ArrayList<Integer>> adj){
            visit[index] = true;
            Queue<Pair> queue = new LinkedList<>();
            queue.add(new Pair(index, -1));

            while(!queue.isEmpty()){
                Pair pair = queue.peek();
                int node = pair.getNode();
                int parent = pair.getParent();
                queue.remove();
                for(int adjNode : adj.get(node)){
                    if(!visit[adjNode]){
                        visit[adjNode] = true;
                        queue.add(new Pair(adjNode, node));
                    } else if(parent!=adjNode){
                        return true;
                    }
                }
            }
            return false;
        }

}
