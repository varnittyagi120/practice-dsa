package src.Trees.sametree;

import src.Trees.VerticalOrderTraversal;

public class Solution {
    class TreeNode{
        int val;
        TreeNode left, right;
        TreeNode(int data){
            this.val = data;
            this.left = null;
            this.right = null;
        }
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null){
            return true;
        }

        if((p==null&&q!=null) || (p!=null&&q==null)){
            return false;
        }
        if(p.val!=q.val){
            return false;
        }
        boolean left = isSameTree( p.left,  q.left);
        boolean right = isSameTree( p.right, q.right);
        if(left && right){
            return true;
        }
        return false;
    }
}
