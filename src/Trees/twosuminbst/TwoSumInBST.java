package src.Trees.twosuminbst;

import java.util.Stack;

public class TwoSumInBST {


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
    class BSTIterator{
        Stack<TreeNode> elementStack = new Stack<>();
        boolean reverse = true;
        public BSTIterator(TreeNode root, boolean reverse){
            this.reverse = reverse ;
            pushAll(root);
        }

        public boolean hashNext(){
            return !elementStack.isEmpty();
        }

        public int next(){
            TreeNode currentNode = elementStack.pop();
            if(!reverse){
                pushAll(currentNode.right);
            } else {
                pushAll(currentNode.left);
            }
            return currentNode.val;
        }

        public void pushAll(TreeNode node){
            while(node!=null){
                elementStack.push(node);
                if(reverse){
                    node = node.right;
                } else {
                    node = node.left;
                }
            }
        }
    }
        public boolean findTarget(TreeNode root, int k) {
            if(root==null){
                return false;
            }
            BSTIterator l = new BSTIterator(root, false);
            BSTIterator r = new BSTIterator(root, true);
            int start = l.next();
            int end = r.next();
            while(start<end){
                if(start+end==k){
                    return true;
                } else if(start+end<k){
                    start = l.next();
                } else {
                    end = r.next();
                }
            }
            return false;
        }
}
