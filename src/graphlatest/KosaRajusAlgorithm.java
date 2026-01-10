package src.graphlatest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

//time complexity O(V+E)
//space complexity O(2*V)
public class KosaRajusAlgorithm {
        // Function to find number of strongly connected components in the graph.
        public int kosaraju(ArrayList<ArrayList<Integer>> adj) {
            // code here
            int result = 0;
            int V = adj.size();
            boolean[] visit = new boolean[V];
            Arrays.fill(visit, false);
            Stack<Integer> st = new Stack<Integer>();
            //O(V+E)
            for(int i=0;i<V;i++){
                if(!visit[i]){
                    dfs(i, st, adj, visit);
                }
            }
            ArrayList<ArrayList<Integer>> adjT = new ArrayList<>();
            for(int i=0;i<V;i++){
                adjT.add(new ArrayList<>());
            }
            //O(V+E)
            for(int i=0;i<V;i++){
                visit[i] = false;
                for(Integer element : adj.get(i)){
                    adjT.get(element).add(i);
                }
            }
            //O(V+E)
            while(!st.isEmpty()){
                int top = st.peek();
                st.pop();
                if(!visit[top]){
                    result++;
                    dfs3(top, adjT, visit);
                }
            }
            return result;
        }

        private void dfs(int node, Stack<Integer> st, ArrayList<ArrayList<Integer>> adj, boolean[] visit){
            visit[node] = true;
            for(Integer element:adj.get(node)){
                if(!visit[element]){
                    dfs(element, st, adj, visit);
                }
            }
            st.push(node);
        }

        private void dfs3(int node, ArrayList<ArrayList<Integer>> adjT, boolean[] visit){
            visit[node] = true;
            for(Integer element : adjT.get(node)){
                if(!visit[element]){
                    dfs3(element, adjT, visit);
                }
            }
        }
}
