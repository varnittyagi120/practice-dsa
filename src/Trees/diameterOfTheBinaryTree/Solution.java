package src.Trees.diameterOfTheBinaryTree;

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
    public int diameterOfBinaryTree(TreeNode root) {
        int[] result = new int[1];
        findDiameterOfTree(root, result);
        return result[0];
    }

    private int findDiameterOfTree(TreeNode root, int[] result){
        if(root==null){
            return 0;
        }
        int lh = findDiameterOfTree(root.left, result);
        int rh = findDiameterOfTree(root.right, result);
        result[0] = Math.max(result[0], lh+rh);
        return 1 + Math.max(lh, rh);
    }
}
