package src.Graph.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    // Function to return Breadth First Search Traversal of given graph.
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        int V = adj.size();
        boolean[] visitedNodes = new boolean[V];
        visitedNodes[0] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        ArrayList<Integer> result = new ArrayList<>();
        while(!queue.isEmpty()){
            int node = queue.poll();
            result.add(node);
            for(Integer itr : adj.get(node)){
                if(!visitedNodes[itr]){
                    visitedNodes[itr] = true;
                    queue.add(itr);
                }
            }
        }
        return result;
    }
}
