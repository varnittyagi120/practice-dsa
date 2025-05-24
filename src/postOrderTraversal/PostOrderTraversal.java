package src.postOrderTraversal;

import java.util.List;

public class PostOrderTraversal {
    class Node{
        int data;
        Node left, right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private void postOrderTraversal(List<Integer> result, Node root){
        if(root==null){
            return;
        }
        postOrderTraversal(result, root.left);
        postOrderTraversal(result, root.right);
        result.add(root.data);
    }
}
