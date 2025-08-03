package src.Trees.childrensuminbinarytree;

public class ChildrenSumInBinaryTree {
    class Node{
        int data;
        Node left,right;

        Node(int key)
        {
            data = key;
            left = right = null;
        }
    }
        public static int isSumProperty(Node root) {
            // add your code here
            int[] result = new int[1];
            result[0] = 1;
            checkChildrenSumInBinaryTree(root, result);
            return result[0];
        }

        private static void checkChildrenSumInBinaryTree(Node root, int[] result){
            if(root==null){
                return;
            }
            if(root.left!=null && root.right!=null){
                if((root.left.data + root.right.data) != root.data){
                    result[0] = 0;
                }
            }

            if(root.left==null && root.right!=null){
                if(root.right.data != root.data){
                    result[0] = 0;
                }
            }

            if(root.left!=null && root.right==null){
                if(root.left.data != root.data){
                    result[0] = 0;
                }
            }
            checkChildrenSumInBinaryTree(root.left, result);
            checkChildrenSumInBinaryTree(root.right, result);

        }
}
