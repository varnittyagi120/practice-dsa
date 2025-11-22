package src.graphlatest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//Time Complexity O(V+E)
//space complexity O(V)
//this is using topo sort
public class DetectCycleInDirectedGraphTopoSort {
        public boolean isCyclic(int V, int[][] edges) {
            // code here
            ArrayList<ArrayList<Integer>>  adj = getAdjList(V, edges);
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
                int edge = queue.peek();
                queue.remove();
                result.add(edge);
                for(int element : adj.get(edge)){
                    indegree[element]--;
                    if(indegree[element]==0){
                        queue.add(element);
                    }
                }
            }

            if(result.size()==V){
                return false;
            }
            return true;
        }

        private ArrayList<ArrayList<Integer>> getAdjList(int V, int[][] edges){
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for(int i=0;i<V;i++){
                adj.add(new ArrayList<>());
            }

            for(int[] edge:edges){
                adj.get(edge[0]).add(edge[1]);
            }
            return adj;
        }
}
