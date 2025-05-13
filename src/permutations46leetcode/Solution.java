package src.permutations46leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        findPermutation(result, nums, 0, nums.length-1);
        return result;
    }

    private void findPermutation(List<List<Integer>> result, int[] nums, int l, int r){
        if(l==r){
            updatePermutationToResult(result, nums);
            return;
        }
        for(int i=l;i<=r;i++){
            swapNumbers(nums, l, i);
            findPermutation(result, nums, l+1, r);
            swapNumbers(nums, l, i);
        }

    }

    private void swapNumbers(int[] nums, int l, int r){
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }

    private void updatePermutationToResult(List<List<Integer>> result, int[] nums){
        List<Integer> permutation = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            permutation.add(nums[i]);
        }
        result.add(permutation);
    }
}
