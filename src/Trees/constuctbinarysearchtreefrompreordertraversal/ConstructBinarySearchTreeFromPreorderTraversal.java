package src.Trees.constuctbinarysearchtreefrompreordertraversal;

public class ConstructBinarySearchTreeFromPreorderTraversal {
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
    public TreeNode bstFromPreorder(int[] preorder) {
        return getTreeNode(preorder, Integer.MAX_VALUE, new int[]{0});
    }

    private TreeNode getTreeNode(int[] preorder, int max, int[] i){
        if(i[0]==preorder.length || preorder[i[0]]>max){
            return null;
        }

        TreeNode root = new TreeNode(preorder[i[0]++]);
        root.left = getTreeNode(preorder, root.val, i);
        root.right = getTreeNode(preorder, max, i);
        return root;
    }
}
