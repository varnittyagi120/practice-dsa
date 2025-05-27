package src.Trees.leftviewofatree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    class Node{
        int data;
        Node left, right;
        Node(int data){
            this.data = data;
            left=right=null;
        }
    }
    ArrayList<Integer> leftView(Node root) {
        // code here
        ArrayList<Integer> result = new ArrayList<>();
        if(root==null){
            return new ArrayList<>();
        }
        Map<Integer, Integer> mapOfNodeValues = new HashMap<>();
        getLeftViewOfTheTree(root, mapOfNodeValues, 0);
        for(Map.Entry<Integer, Integer> map:mapOfNodeValues.entrySet()){
            result.add(map.getValue());
        }
        return result;
    }

    private void getLeftViewOfTheTree(Node root, Map<Integer, Integer> mapOfNodeValues, int level){
        if(root==null){
            return;
        }
        if(!mapOfNodeValues.containsKey(level)){
            mapOfNodeValues.put(level, root.data);
        }
        getLeftViewOfTheTree(root.left, mapOfNodeValues, level+1);
        getLeftViewOfTheTree(root.right, mapOfNodeValues, level+1);
    }
}
