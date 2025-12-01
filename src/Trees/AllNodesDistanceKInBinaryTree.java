package src.Trees;

import java.util.*;

//TC : O(n)
//SC : O(n)
public class AllNodesDistanceKInBinaryTree {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
        class Pair{
            int first;
            int second;
            Pair(int first, int second){
                this.first = first;
                this.second = second;
            }

            public int getFirst(){
                return this.first;
            }

            public int getSecond(){
                return this.second;
            }
        }
        Map<Integer, List<Integer>> adj = new HashMap<>();
        private void addEdge(int u, int v){
            //System.out.println(u+" "+v);
            adj.putIfAbsent(u, new ArrayList<>());
            adj.putIfAbsent(v, new ArrayList<>());
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        private void getAdjList(TreeNode root){
            if(root==null){
                return;
            }
            if(root.left!=null){
                addEdge(root.val, root.left.val);
                getAdjList(root.left);
            }

            if(root.right!=null){
                addEdge(root.val, root.right.val);
                getAdjList(root.right);
            }
        }
        public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
            List<Integer> list = new ArrayList<>();
            getAdjList(root);
            if(adj.size()<k){
                return list;
            }
            if(k==0){
                list.add(target.val);
                return list;
            }
            System.out.println(adj);
            boolean[] visit = new boolean[adj.size()];
            Arrays.fill(visit, false);
            Queue<Pair> q = new LinkedList<>();
            q.add(new Pair(target.val, 0));
            visit[target.val] = true;

            while(!q.isEmpty()){
                Pair pair = q.poll();
                int top = pair.getFirst();
                int level = pair.getSecond();
                level++;
                for(int element : adj.get(top)){
                    if(!visit[element]){
                        visit[element] = true;
                        if(level==k){
                            System.out.println(element);
                            list.add(element);
                        }
                        q.add(new Pair(element, level));
                    }
                }
            }
            System.out.println(list);
            return list;
        }
}
