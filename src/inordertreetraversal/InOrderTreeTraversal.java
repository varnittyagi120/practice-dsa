package src.inordertreetraversal;


import java.util.List;

public class InOrderTreeTraversal {
    class Node{
        int data;
        Node left, right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private void inOrderTraversal(List<Integer> result, Node root){
        if(root==null){
            return;
        }
        inOrderTraversal(result, root.left);
        result.add(root.data);
        inOrderTraversal(result, root.right);
    }
}
