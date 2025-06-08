package src.Trees.balancedbinarytree;

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

    public boolean isBalanced(TreeNode root) {
        boolean[] result = new boolean[1];
        result[0] = true;
        isTreeBalanced(root, result);
        return result[0];
    }

    private int isTreeBalanced(TreeNode root, boolean[] result){
        if(root==null){
            return 0;
        }
        int lh = isTreeBalanced(root.left, result);
        int rh = isTreeBalanced(root.right, result);
        int diff = lh>rh ? lh-rh : rh-lh;
        if(diff>1){
            result[0] = false;
            return 0;
        }
        return 1 + Math.max(lh, rh);
    }
}
