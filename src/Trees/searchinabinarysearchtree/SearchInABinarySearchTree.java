package src.Trees.searchinabinarysearchtree;

import src.Trees.sametree.Solution;

public class SearchInABinarySearchTree {

    class TreeNode{
        int val;
        TreeNode left, right;
        TreeNode(int data){
            this.val = data;
            this.left = null;
            this.right = null;
        }
    }
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode[] result = new TreeNode[1];
        searchInBST(root, val, result);
        return result.length==0?null:result[0];
    }

    private TreeNode searchInBST(TreeNode root, int val, TreeNode[] result) {
        if(root==null){
            return null;
        }

        if(root.val==val){
            result[0] = root;
            return root;
        }

        if(root.val>val){
            searchInBST(root.left, val, result);
        } else {
            searchInBST(root.right, val, result);
        }
        return null;
    }
}
