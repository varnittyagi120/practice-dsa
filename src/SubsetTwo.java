package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetTwo {
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> result = new ArrayList<>();
            subsets(nums, result, new ArrayList<>(), 0);
            return result;
        }

        private void subsets(int[] nums, List<List<Integer>> result, List<Integer> temp, int index){
            result.add(new ArrayList<>(temp));
            for(int i=index;i<nums.length;i++){
                if(i!=index && nums[i]==nums[i-1]){
                    continue;
                }
                temp.add(nums[i]);
                subsets(nums, result, temp, i+1);
                temp.remove(temp.size()-1);
            }
        }
}
