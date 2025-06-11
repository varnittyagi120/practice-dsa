package src.Trees.deepestleavessum;

import java.util.LinkedList;
import java.util.Queue;

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
    public int deepestLeavesSum(TreeNode root) {
        if(root==null){
            return 0;
        }
        int result = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            int sum = 0;
            for(int i=0;i<size;i++){
                TreeNode treeNode = queue.poll();
                sum = sum + treeNode.val;
                if(treeNode.left!=null){
                    queue.add(treeNode.left);
                }

                if(treeNode.right!=null){
                    queue.add(treeNode.right);
                }
            }
            result = sum;
        }
        return result;
    }
}
