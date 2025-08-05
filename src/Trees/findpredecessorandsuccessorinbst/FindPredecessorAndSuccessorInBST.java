package src.Trees.findpredecessorandsuccessorinbst;

import java.util.ArrayList;

public class FindPredecessorAndSuccessorInBST {
    class Node {
        int data;
        Node left, right;
        Node(int x) {
            data = x;
            left = right = null;
        }
    }
    public ArrayList<Node> findPreSuc(Node root, int key) {
        ArrayList<Node> result = new ArrayList<>();
        // code here
        Node[] predecessor = new Node[1];
        Node[] successor = new Node[1];
        findPredecessorAndSuccessor(root, key, predecessor, successor);
        if(predecessor.length==0){
            result.add(null);
        } else {
            result.add(predecessor[0]);
        }

        if(successor.length==0){
            result.add(null);
        } else {
            result.add(successor[0]);
        }

        return result;
    }

    private void findPredecessorAndSuccessor(Node root, int key, Node[] pre, Node[] successor){
        if(root==null){
            return;
        }
        if(pre.length!=0 && pre[0]!=null){
            if(pre[0].data<root.data && root.data<key){
                pre[0] = root;
            }
        } else {
            if(root.data<key){
                pre[0] = root;
            }
        }

        if(successor.length!=0 && successor[0]!=null){
            if(successor[0].data>root.data && root.data>key){
                successor[0] = root;
            }
        } else {
            if(root.data>key){
                successor[0] = root;
            }
        }
        findPredecessorAndSuccessor(root.left, key, pre, successor);
        findPredecessorAndSuccessor(root.right, key, pre, successor);
    }
}
