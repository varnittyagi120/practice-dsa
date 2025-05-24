package src.levelordertraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    class TreeNode{
        int val;
        TreeNode left, right;
        TreeNode(int data){
            this.val = data;
            this.left = null;
            this.right = null;
        }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> temp =  new ArrayList<>();
            for(int i=0;i<size;i++){
                if(queue.peek().left!=null){
                    queue.offer(queue.peek().left);
                }
                if(queue.peek().right!=null){
                    queue.offer(queue.peek().right);
                }
                temp.add(queue.poll().val);
            }
            result.add(temp);
        }
        return result;
    }
}
