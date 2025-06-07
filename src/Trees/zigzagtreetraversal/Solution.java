package src.Trees.zigzagtreetraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean leftToRight = true;
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> listOfIntegers =  new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                listOfIntegers.add(node.val);
                if(node.left!=null){
                    queue.add(node.left);
                }

                if(node.right!=null){
                    queue.add(node.right);
                }
            }
            if(!leftToRight){
                reverseArrayList(listOfIntegers);
            }
            leftToRight = !leftToRight;
            result.add(listOfIntegers);
        }
        return result;
    }

    private void reverseArrayList(List<Integer> listOfIntegers){
        int start = 0;
        int end = listOfIntegers.size()-1;
        while(start<end){
            int startTemp = listOfIntegers.get(start);
            int endTemp = listOfIntegers.get(end);
            listOfIntegers.set(end, startTemp);
            listOfIntegers.set(start, endTemp);
            start++;
            end--;
        }
    }
}
