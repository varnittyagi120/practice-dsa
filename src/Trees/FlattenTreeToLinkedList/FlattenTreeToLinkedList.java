package src.Trees.FlattenTreeToLinkedList;

import src.Trees.diameterOfTheBinaryTree.Solution;

public class FlattenTreeToLinkedList {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public void flatten(TreeNode root) {
        TreeNode currentNode = root;
        while(currentNode!=null){
            if(currentNode.left!=null){
                TreeNode prev = currentNode.left;
                while(prev.right!=null){
                    prev = prev.right;
                }
                prev.right = currentNode.right;
                currentNode.right = currentNode.left;
                currentNode.left = null;
            }
            currentNode = currentNode.right;
        }
    }
}
