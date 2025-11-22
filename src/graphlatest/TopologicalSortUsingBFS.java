package src.graphlatest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
// Time complexity O(V+E)
// Space complexity O(V)
public class TopologicalSortUsingBFS {
        public ArrayList<Integer> topoSort(int V, int[][] edges) {
            ArrayList<ArrayList<Integer>> adj = getAdjList(V, edges);
            ArrayList<Integer> result = new ArrayList<>();
            int[] indegree = new int[V];
            Arrays.fill(indegree, 0);
            for(int i=0;i<V;i++){
                for(int element : adj.get(i)){
                    indegree[element]++;
                }
            }

            Queue<Integer> queue = new LinkedList<Integer>();
            for(int i=0;i<V;i++){
                if(indegree[i]==0){
                    queue.add(i);
                }
            }

            while(!queue.isEmpty()){
                int element = queue.peek();
                queue.remove();
                result.add(element);
                for(int edge : adj.get(element)){
                    indegree[edge]--;
                    if(indegree[edge]==0){
                        queue.add(edge);
                    }
                }
            }
            return result;

        }

        private ArrayList<ArrayList<Integer>> getAdjList(int V, int[][] edges){
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for(int i=0;i<V;i++){
                adj.add(new ArrayList<>());
            }

            for(int[] edge: edges){
                adj.get(edge[0]).add(edge[1]);
            }
            return adj;
        }


}
