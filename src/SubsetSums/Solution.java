package src.SubsetSums;

import java.util.ArrayList;

public class Solution {
    public ArrayList<Integer> subsetSums(int[] arr) {
        // code here
        ArrayList<Integer> result = new ArrayList<>();
        findSubsetSum(arr, 0, 0, result);
        return result;
    }

    private void findSubsetSum(int[] arr, int l, int sum, ArrayList<Integer> result){
        if(l>=arr.length){
            result.add(sum);
            return;
        }
        findSubsetSum(arr, l+1, sum+arr[l], result);
        findSubsetSum(arr, l+1, sum, result);
    }
}
