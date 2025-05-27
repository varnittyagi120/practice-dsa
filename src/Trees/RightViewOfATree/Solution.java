package src.Trees.RightViewOfATree;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        Map<Integer, Integer> mapOfRightSideNodes = new HashMap<>();
        mapOfRightSideNodes(root, mapOfRightSideNodes, 0);
        for(Map.Entry<Integer, Integer> map : mapOfRightSideNodes.entrySet()){
            result.add(map.getValue());
        }
        return result;
    }

    private void mapOfRightSideNodes(TreeNode root, Map<Integer, Integer> mapOfRightSideNodes, int level){
        if(root==null){
            return;
        }
        mapOfRightSideNodes.put(level, root.val);
        mapOfRightSideNodes(root.left, mapOfRightSideNodes, level+1);
        mapOfRightSideNodes(root.right, mapOfRightSideNodes, level+1);
    }
}
