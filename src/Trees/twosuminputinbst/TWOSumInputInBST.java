package src.Trees.twosuminputinbst;

import src.Trees.searchinabinarysearchtree.SearchInABinarySearchTree;

import java.util.HashMap;
import java.util.Map;

public class TWOSumInputInBST {
    class TreeNode{
        int val;
        TreeNode left, right;
        TreeNode(int data){
            this.val = data;
            this.left = null;
            this.right = null;
        }
    }

    public boolean findTarget(TreeNode root, int k) {
        if(root!=null && root.left==null && root.right==null){
            return false;
        }
        Map<Integer, Integer> mapOfIntegers = new HashMap<>();
        getMapOfIntegers(mapOfIntegers, root);
        return checkPairExist(mapOfIntegers, root, k);
    }

    private boolean checkPairExist(Map<Integer, Integer> mapOfIntegers, TreeNode root, int k){
        if(root==null){
            return false;
        }
        int diff = k-root.val;
        if(mapOfIntegers.containsKey(diff) && diff!=root.val){
            return true;
        }
        return (checkPairExist(mapOfIntegers, root.left, k)|| checkPairExist(mapOfIntegers, root.right, k));
    }

    private void getMapOfIntegers(Map<Integer, Integer> mapOfIntegers, TreeNode root){
        if(root==null){
            return;
        }

        getMapOfIntegers(mapOfIntegers, root.left);
        mapOfIntegers.put(root.val, 1);
        getMapOfIntegers(mapOfIntegers, root.right);

    }
}
