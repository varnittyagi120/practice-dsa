package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// time complexity O(2^n)
// space complexity O(n)
public class CombinatiomSumTwo {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            List<List<Integer>> result = new ArrayList<>();
            Arrays.sort(candidates);
            findCombinationSumTwo(candidates, target, result, new ArrayList<>(), 0);
            return result;
        }

        private void findCombinationSumTwo(int[] candidates, int target, List<List<Integer>> result, List<Integer> temp, int index) {
            if (target == 0) {
                result.add(new ArrayList<>(temp));
                return;
            }

            for (int i = index; i < candidates.length; i++) {
                if (i > index && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                if (candidates[i] > target) {
                    break;
                }
                temp.add(candidates[i]);
                findCombinationSumTwo(candidates, target - candidates[i], result, temp, i + 1);
                temp.remove(temp.size() - 1);
            }
        }
}
