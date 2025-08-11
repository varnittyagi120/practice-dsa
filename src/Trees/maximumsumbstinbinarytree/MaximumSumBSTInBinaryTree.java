package src.Trees.maximumsumbstinbinarytree;

public class MaximumSumBSTInBinaryTree {

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
    class NodeValue{
        int minValue;
        int maxValue;
        int sum;
        public NodeValue(int minValue, int maxValue, int sum){
            this.minValue = minValue;
            this.maxValue = maxValue;
            this.sum = sum;
        }

    }
    class Solution {
        public int maxSumBST(TreeNode root) {
            int[] result = new int[1];
            result[0] = 0;
            findLargestBinarySearchTree(root, result);
            return result[0];
        }

        private NodeValue findLargestBinarySearchTree(TreeNode root, int[] result){
            if(root==null){
                return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
            }

            NodeValue leftNode = findLargestBinarySearchTree(root.left, result);
            NodeValue rightNode = findLargestBinarySearchTree(root.right, result);
            if(leftNode.maxValue<root.val && root.val<rightNode.minValue){
                int totalSum = root.val + leftNode.sum + rightNode.sum;
                if(totalSum>result[0]){
                    result[0] = totalSum;
                }
                return new NodeValue(Math.min(leftNode.minValue, root.val), Math.max(rightNode.maxValue, root.val), totalSum);
            }
            return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
        }
    }
}
