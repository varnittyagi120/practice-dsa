package src.Trees;

import java.util.*;

public class TopViewOfTheTree {
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

    class Pair{
        Node root;
        int data;
        Pair(Node root, int data){
            this.root = root;
            this.data = data;
        }

        public Node getKey(){
            return this.root;
        }

        public int getValue(){
            return this.data;
        }
    }


        // Function to return a list of nodes visible from the top view
        // from left to right in Binary Tree.
        static ArrayList<Integer> topView(Node root) {
            // code here
            //map of vertical level vs root data
            ArrayList<Integer> result = new ArrayList<>();
            Map<Integer, Integer> mapOfRootData = new TreeMap<>();
            Queue<Pair> queueOfData = new LinkedList<>();
            queueOfData.add(new Pair(root,0));
            while(!queueOfData.isEmpty()){
                Pair pair = queueOfData.poll();
                if(pair.getKey().left!=null){
                    queueOfData.add(new Pair(pair.getKey().left, pair.getValue()-1));
                }
                if(pair.getKey().right!=null){
                    queueOfData.add(new Pair(pair.getKey().right, pair.getValue()+1));
                }
                if(!mapOfRootData.containsKey(pair.getValue())){
                    mapOfRootData.put(pair.getValue(), pair.getKey().data);
                }
            }

            for(Map.Entry<Integer, Integer> map:mapOfRootData.entrySet()){
                result.add(map.getValue());
            }
            return result;
        }

}
