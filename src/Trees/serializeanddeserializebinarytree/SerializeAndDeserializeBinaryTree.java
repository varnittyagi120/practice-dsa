package src.Trees.serializeanddeserializebinarytree;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {


      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if(root==null){
                return null;
            }
            StringBuilder serializedString = new StringBuilder();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while(!queue.isEmpty()){
                TreeNode node = queue.poll();
                if(node==null){
                    serializedString.append("#").append(",");
                    continue;
                }
                serializedString.append(node.val).append(",");
                queue.add(node.left);
                queue.add(node.right);
            }
            return serializedString.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if(data==null || data.length()==0){
                return null;
            }
            String[] treeElements = data.split(",");
            TreeNode treeNode = new TreeNode(Integer.parseInt(treeElements[0]));
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(treeNode);
            for(int i=1;i<treeElements.length;i++){
                TreeNode currentNode = queue.poll();
                if(!treeElements[i].equals("#")){
                    TreeNode left = new TreeNode(Integer.parseInt(treeElements[i]));
                    currentNode.left = left;
                    queue.add(left);
                }

                if(!treeElements[++i].equals("#")){
                    TreeNode right = new TreeNode(Integer.parseInt(treeElements[i]));
                    currentNode.right = right;
                    queue.add(right);
                }
            }
            return treeNode;
        }
    }
}
