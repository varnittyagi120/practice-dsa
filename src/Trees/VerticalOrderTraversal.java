package src.Trees;

import src.Trees.RightViewOfATree.Solution;

import java.util.*;

public class VerticalOrderTraversal {
    class TreeNode{
        int val;
        TreeNode left, right;
        TreeNode(int data){
            this.val = data;
            this.left = null;
            this.right = null;
        }
    }
    public class Pair<K, V>{
        public K key;
        public V value;
        Pair(K key, V value){
            this.key = key;
            this.value = value;
        }

        public K getKey(){
            return this.key;
        }

        public V getValue(){
            return this.value;
        }
    }
    class Solution {
        public List<List<Integer>> verticalTraversal(TreeNode root) {
            List<List<Integer>> listOfIntegers =new ArrayList<>();
            Map<Integer, Map<Integer, List<Integer>>> mapOfRoots = new TreeMap<>();
            Queue<Pair<TreeNode, Pair<Integer, Integer>>> queue = new LinkedList<>();
            queue.add(new Pair<>(root, new Pair<>(0,0)));
            while(!queue.isEmpty()){
                Pair pair = queue.poll();
                TreeNode key = (TreeNode) pair.getKey();
                Pair<Integer, Integer> value = (Pair<Integer, Integer>)pair.getValue();
                if(key.left!=null){
                    queue.add(new Pair<>(key.left, new Pair<>(value.getKey()-1, value.getValue()+1)));
                }

                if(key.right!=null){
                    queue.add(new Pair<>(key.right, new Pair<>(value.getKey()+1, value.getValue()+1)));
                }
                if(!mapOfRoots.containsKey(value.getKey())){
                    Map<Integer, List<Integer>> mapOfRootWithLevels = new TreeMap<>();
                    List<Integer> treeSet = new ArrayList<>();
                    treeSet.add(key.val);
                    mapOfRootWithLevels.put(value.getValue(), treeSet);
                    mapOfRoots.put(value.getKey(), mapOfRootWithLevels);
                } else {
                    Map<Integer, List<Integer>> mapOfRootWithLevels = mapOfRoots.get(value.getKey());
                    if(mapOfRootWithLevels.containsKey(value.getValue())){
                        List<Integer> treeSet = mapOfRootWithLevels.get(value.getValue());
                        treeSet.add(key.val);
                        Collections.sort(treeSet);
                    } else {
                        List<Integer> treeSet = new ArrayList<>();
                        treeSet.add(key.val);
                        mapOfRootWithLevels.put(value.getValue(), treeSet);
                    }
                }
            }
            for(Map.Entry<Integer, Map<Integer, List<Integer>>> map: mapOfRoots.entrySet()){
                List<Integer> integerList = new ArrayList<>();
                for(Map.Entry<Integer, List<Integer>> map1 : map.getValue().entrySet()){
                    integerList.addAll(new ArrayList<>(map1.getValue()));
                }
                listOfIntegers.addAll(Collections.singleton(integerList));
            }
            return listOfIntegers;
        }

    }
}
