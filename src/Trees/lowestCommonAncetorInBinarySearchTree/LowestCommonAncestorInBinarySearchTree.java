package src.Trees.lowestCommonAncetorInBinarySearchTree;

import src.Trees.sametree.Solution;

public class LowestCommonAncestorInBinarySearchTree {
    class TreeNode{
        int val;
        TreeNode left, right;
        TreeNode(int data){
            this.val = data;
            this.left = null;
            this.right = null;
        }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode[] result = new TreeNode[1];
        findLowestCommonAncestor(root, p, q, result);
        return result[0];
    }

    private void findLowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q, TreeNode[] result){
        if(root==null){
            return;
        }
        if(root.val>p.val && root.val>q.val){
            findLowestCommonAncestor(root.left, p, q, result);
        } else if(root.val<p.val && root.val<q.val){
            findLowestCommonAncestor(root.right, p, q, result);
        } else {
            result[0] = root;
            return;
        }
    }

}
