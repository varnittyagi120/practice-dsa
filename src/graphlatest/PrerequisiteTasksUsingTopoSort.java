package src.graphlatest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class PrerequisiteTasksUsingTopoSort {
    // User function Template for Java

        public boolean isPossible(int N, int P, int[][] prerequisites) {
            // Your Code goes here
            ArrayList<ArrayList<Integer>> adj = getAdjList(N, prerequisites);
            ArrayList<Integer> result = new ArrayList<>();
            int[] indegree = new int[N];
            Arrays.fill(indegree, 0);
            for(int i=0;i<N;i++){
                for(int element : adj.get(i)){
                    indegree[element]++;
                }
            }

            Queue<Integer> queue = new LinkedList<Integer>();
            for(int i=0;i<N;i++){
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
            if(result.size()==N){
                return true;
            }
            return false;
        }

        private ArrayList<ArrayList<Integer>> getAdjList(int N, int[][] prerequisites){
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for(int i = 0;i<N;i++){
                adj.add(new ArrayList<>());
            }

            for(int[] prereq : prerequisites){
                adj.get(prereq[0]).add(prereq[1]);
            }
            return adj;
        }
}
