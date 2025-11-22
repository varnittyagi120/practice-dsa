package src.graphlatest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

//time complexity will be O(V+E)
//space complexity O(V)
public class TopologicalSorting {
        public ArrayList<Integer> topoSort(int V, int[][] edges) {
            // code here
            int[] visit = new int[V];
            ArrayList<ArrayList<Integer>> adj = getAdjList(V, edges);
            Arrays.fill(visit, 0);
            Stack<Integer> result = new Stack<>();
            for(int i=0;i<V;i++){
                if(visit[i]==0){
                    findTopologicalSort(i, visit, result, adj);
                }
            }

            ArrayList<Integer> res = new ArrayList<>();
            while(!result.isEmpty()){
                int element = result.peek();
                res.add(element);
                result.pop();
            }
            return res;
        }

        private void findTopologicalSort(int start, int[] visit, Stack<Integer> stack, ArrayList<ArrayList<Integer>> adj){
            visit[start] = 1;
            for(int element : adj.get(start)){
                if(visit[element]==0){
                    findTopologicalSort(element, visit, stack, adj);
                }
            }
            stack.add(start);
        }

        private ArrayList<ArrayList<Integer>> getAdjList(int V, int[][] edges){
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for(int i=0;i<V;i++){
                adj.add(new ArrayList<>());
            }

            for(int[] edge : edges){
                adj.get(edge[0]).add(edge[1]);
            }
            return adj;
        }
}
