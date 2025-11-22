package src.graphlatest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
// time complexity O(V+E)
//space complexity O(V)
public class CourseScheduleIUsingTopoSort {
        public boolean canFinish(int n, int[][] prerequisites) {
            // code here
            ArrayList<ArrayList<Integer>> adj = getAdjList(n, prerequisites);
            ArrayList<Integer> result = new ArrayList<>();
            int[] indegree  = new int[n];
            Arrays.fill(indegree, 0);
            for(int i=0;i<n;i++){
                for(int element : adj.get(i)){
                    indegree[element]++;
                }
            }

            Queue<Integer> queue = new LinkedList<Integer>();
            for(int i=0;i<n;i++){
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
            if(result.size()==n){
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
                adj.get(prereq[1]).add(prereq[0]);
            }
            return adj;
        }
}
