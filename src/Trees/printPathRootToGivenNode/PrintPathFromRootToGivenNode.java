package src.Trees.printPathRootToGivenNode;

import java.util.ArrayList;
import java.util.List;
import java.util.ListResourceBundle;

public class PrintPathFromRootToGivenNode {
    static class Node {
        int data;
        Node left, right;
        Node(int data){
             this.data = data;
             this.left = null;
             this.right = null;
        }
    }

    private static boolean findPathFromRootToGivenNode(Node root, List<Integer> integerList, int target){
        if(root == null){
            return false;
        }
        integerList.add(root.data);
        if(root.data==target){
            return true;
        }
        if(findPathFromRootToGivenNode(root.left, integerList, target) || findPathFromRootToGivenNode(root.right, integerList, target)){
            return true;
        }
        integerList.remove(integerList.size()-1);
        return false;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        printPath(root);
        List<Integer> integerList = new ArrayList<>();

        findPathFromRootToGivenNode(root, integerList, 5);
        System.out.println("root to node path");
        for (Integer integer :integerList) {
            System.out.println(integer);
        }
    }

    private static void printPath(Node root) {
        if(root==null){
            return;
        }
        System.out.println(root.data);
        printPath(root.left);
        printPath(root.right);
    }
}
