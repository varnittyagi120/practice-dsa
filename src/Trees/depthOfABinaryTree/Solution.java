package src.Trees.depthOfABinaryTree;

public class Solution {
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
    public int maxDepth(TreeNode root) {
        return findHeightOfTheTree(root);
    }

    private int findHeightOfTheTree(TreeNode root){
        if(root==null){
            return 0;
        }
        return Math.max(findHeightOfTheTree(root.left)+1, findHeightOfTheTree(root.right)+1);
    }
}
