package src.Trees.buildatreefrompreorderandinorder;

import java.util.HashMap;
import java.util.Map;

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> mapOfIntegers = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            mapOfIntegers.put(inorder[i], i);
        }
        TreeNode treeNode = buildTree1(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, mapOfIntegers);
        return treeNode;
    }


    private TreeNode buildTree1(int[] preorder, int prestart, int preend, int[] inorder, int instart, int inend, Map<Integer, Integer> map){
        if(prestart>preend || instart>inend){
            return null;
        }
        TreeNode root = new TreeNode(preorder[prestart]);
        int rootPositionInFirstArray = map.get(preorder[prestart]);
        int numAtLeftSide = rootPositionInFirstArray-instart;
        root.left = buildTree1(preorder, prestart+1, prestart+numAtLeftSide,inorder, instart, rootPositionInFirstArray-1, map);
        root.right = buildTree1(preorder, prestart+numAtLeftSide+1, preend,inorder, rootPositionInFirstArray+1, inend, map);
        return root;
    }
}
