package src;

import java.util.ArrayList;
import java.util.List;

//time complexity O(2^n) or (K*N)
//space complexity : O(target) for recursion stack + O(number of combinations × length)
public class CombinationSumOne {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> result = new ArrayList<>();
            findCombinationSum(candidates, target, result, 0, new ArrayList<>());
            return result;
        }

        private void findCombinationSum(int[] candidates, int target, List<List<Integer>> result, int index, List<Integer> temp){
            if(index==candidates.length){
                if(target==0){
                    result.add(new ArrayList<>(temp));
                }
                return;
            }

            if(candidates[index]<=target){
                temp.add(candidates[index]);
                System.out.println(temp);
                findCombinationSum(candidates, target-candidates[index], result, index, temp);
                System.out.println("backtracking "+temp);
                temp.remove(temp.size()-1);
            }
            findCombinationSum(candidates, target, result, index+1, temp);
        }

}
