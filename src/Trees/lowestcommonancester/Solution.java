package src.Trees.lowestcommonancester;

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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || root==p || root==q){
            return root;
        }

        TreeNode leftNode = lowestCommonAncestor(root.left,  p,  q);
        TreeNode rightNode = lowestCommonAncestor(root.right,  p,  q);
        if(leftNode==null){
            return rightNode;
        } else if(rightNode==null){
            return leftNode;
        } else {
            return root;
        }
    }
}
