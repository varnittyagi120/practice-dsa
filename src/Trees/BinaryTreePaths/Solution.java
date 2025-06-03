package src.Trees.BinaryTreePaths;

import src.Trees.VerticalOrderTraversal;

import java.util.ArrayList;
import java.util.List;

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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        if(root.left==null && root.right==null){
            StringBuilder str = new StringBuilder("");
            str.append(root.val);
            result.add(str.toString());
            return result;
        } else {
            findRootToLeafPath(root, result, new ArrayList<>());
        }
        return result;
    }

    private void findRootToLeafPath(TreeNode root, List<String> result, List<Integer> tempArray){
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
            tempArray.add(root.val);
            populateString(tempArray, result);
            tempArray.remove(tempArray.size()-1);
            return;
        }
        tempArray.add(root.val);
        findRootToLeafPath(root.left, result, tempArray);
        findRootToLeafPath(root.right, result, tempArray);
        tempArray.remove(tempArray.size()-1);
    }

    private void populateString(List<Integer> tempArray, List<String> result){
        StringBuilder str = new StringBuilder("");
        for(int i=0;i<tempArray.size();i++){
            if(i==tempArray.size()-1){
                str.append(tempArray.get(i));
            } else{
                str.append(tempArray.get(i));
                str.append("->");
            }
        }
        result.add(str.toString());
    }
}
