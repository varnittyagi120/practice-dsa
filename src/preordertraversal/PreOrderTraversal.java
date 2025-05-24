package src.preordertraversal;

import java.util.List;

public class PreOrderTraversal {
    public class Node{
        int data;
        Node left, right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private void preOrderTraversal(List<Integer> result, Node root){
        if(root==null){
            return;
        }
        result.add(root.data);
        preOrderTraversal(result, root.left);
        preOrderTraversal(result, root.right);
    }
}
