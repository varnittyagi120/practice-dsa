package src.Trees.populatingnextrightpointersineachnode;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNode {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
    class Pair{
        Node node;
        int level;
        Pair(Node node, int level){
            this.node = node;
            this.level = level;
        }
        public Node getNode(){
            return this.node;
        }

        public int getLevel(){
            return this.level;
        }
    }

    public Node connect(Node root) {
        if(root==null){
            return root;
        }
        Queue<Pair> queue = new LinkedList<>();
        Pair pair = new Pair(root, 0);
        queue.add(pair);
        while(!queue.isEmpty()){
            Pair pair1 = queue.poll();
            Node node = pair1.getNode();
            int level = pair1.getLevel();
            if(node.left!=null){
                Pair leftPair = new Pair(node.left, level+1);
                queue.add(leftPair);
            }

            if(node.right!=null){
                Pair rightPair = new Pair(node.right, level+1);
                queue.add(rightPair);
            }

            if(!queue.isEmpty()){
                Pair queueFront = queue.peek();
                Node frontNode = queueFront.getNode();
                int frontNodeLevel = queueFront.getLevel();
                if(level!=frontNodeLevel){
                    node.next = null;
                } else {
                    node.next = frontNode;
                }
            }
        }

        return root;
    }
}
