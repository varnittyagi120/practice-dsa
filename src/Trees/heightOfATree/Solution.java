package src.Trees.heightOfATree;

public class Solution {

    class Node{
        int data;
        Node left, right;

        Node(int item)
        {
            data = item;
            left = right = null;
        }
    }
    int height(Node node) {
        // code here
        if(node==null){
            return 0;
        }
        return calculateHeight(0, 0, node);
    }

    private int calculateHeight(int level, int height, Node node){
        if(node==null){
            return level-1;
        }

        return Math.max(calculateHeight(level+1, height, node.left), calculateHeight(level+1, height, node.right));
    }
}
