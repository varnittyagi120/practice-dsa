package src.Trees.MaximumPathSum;

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
    public int maxPathSum(TreeNode root) {
        int[] result = new int[1];
        result[0] = Integer.MIN_VALUE;
        maximumPathSum(root, result);
        return result[0];
    }

    private int maximumPathSum(TreeNode root, int[] result){
        if(root==null){
            return 0;
        }
        int left = Math.max(0, maximumPathSum(root.left, result));
        int right = Math.max(0, maximumPathSum(root.right, result));
        result[0] = Math.max(result[0], root.val + left + right);
        return root.val + Math.max(left, right);
    }
}
