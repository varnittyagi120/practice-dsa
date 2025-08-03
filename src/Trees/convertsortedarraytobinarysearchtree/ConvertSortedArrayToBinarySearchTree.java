package src.Trees.convertsortedarraytobinarysearchtree;

public class ConvertSortedArrayToBinarySearchTree {
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
    public TreeNode sortedArrayToBST(int[] nums) {
        return formATreeNode(nums, 0, nums.length-1);
    }

    private TreeNode formATreeNode(int[] nums, int start, int end){
        if(start>end){
            return null;
        }
        int mid = start + (end-start)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = formATreeNode(nums, start, mid-1);
        node.right = formATreeNode(nums, mid+1, end);
        return node;
    }
}
