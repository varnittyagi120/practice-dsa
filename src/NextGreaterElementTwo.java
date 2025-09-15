package src;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElementTwo {
    class Pair{
        int index;
        int value;
        Pair(int index, int value){
            this.index = index;
            this.value = value;
        }

        int getIndex(){
            return index;
        }

        int getValue(){
            return value;
        }

    }
    class Solution {
        public int[] nextGreaterElements(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            int[] result = new int[nums.length];
            Stack<Pair> stack = new Stack<>();
            int j = 0;
            for(int i=0;i<nums.length;i++){
                if(stack.isEmpty()){
                    Pair pair = new Pair(i, nums[i]);
                    stack.push(pair);
                } else {
                    while(!stack.isEmpty() && nums[i]>stack.peek().getValue()){
                        result[stack.peek().getIndex()] = nums[i];
                        stack.pop();
                    }
                    Pair pair = new Pair(i, nums[i]);
                    stack.push(pair);
                }
            }
            if(!stack.isEmpty()){
                for(int i=0;i<nums.length;i++){
                    while(!stack.isEmpty() && nums[i]>stack.peek().getValue()){
                        result[stack.peek().getIndex()] = nums[i];
                        stack.pop();
                    }
                }
            }

            if(!stack.isEmpty()){
                while(!stack.isEmpty()){
                    result[stack.peek().getIndex()] = -1;
                    stack.pop();
                }
            }
            return result;
        }
    }
}
//time complexity O(N)
//space complexity O(N)
