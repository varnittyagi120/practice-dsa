package src.Trees.BottomViewOfTheTree;

import src.Trees.TopViewOfTheTree;

import java.util.*;

public class Solution {
    class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            left=null;
            right=null;
        }
    }
    public ArrayList<Integer> bottomView(Node root) {
        // Code here
        ArrayList<Integer> result = new ArrayList<>();
        Map<Integer, Integer> mapOfRoot = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));
        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            if(pair.getKey().left!=null){
                queue.add(new Pair(pair.getKey().left, pair.getValue()-1));
            }

            if(pair.getKey().right!=null){
                queue.add(new Pair(pair.getKey().right, pair.getValue()+1));
            }
            mapOfRoot.put(pair.getValue(), pair.getKey().data);
        }

        for(Map.Entry<Integer, Integer> map : mapOfRoot.entrySet()){
            result.add(map.getValue());
        }
        return result;

    }

    class Pair{
        Node root;
        int data;
        Pair(Node root, int data){
            this.data=data;
            this.root=root;
        }

        public Node getKey(){
            return this.root;
        }

        public int getValue(){
            return this.data;
        }
    }
}
