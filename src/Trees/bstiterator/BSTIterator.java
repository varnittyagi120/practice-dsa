package src.Trees.bstiterator;

import src.Trees.deepestleavessum.Solution;

import java.util.Stack;

public class BSTIterator {
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

        Stack<TreeNode> stackTracker = new Stack<>();
        public BSTIterator(TreeNode root) {
            pushAll(root);
        }

        public int next() {
            TreeNode currentNode = stackTracker.pop();
            pushAll(currentNode.right);
            return currentNode.val;
        }

        public boolean hasNext() {
            return !stackTracker.isEmpty();
        }

        private void pushAll(TreeNode node){
            for(;node!=null;stackTracker.push(node),node=node.left);
        }
    
}
