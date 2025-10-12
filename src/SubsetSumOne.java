package src;

//TLE
//nums size was 200, we need to use DP here
public class SubsetSumOne {
    class Solution {

        Boolean isSubsetSum(int arr[], int sum) {
            Boolean[] result = new Boolean[1];
            result[0] = false;
            findSubsetSum(arr, sum, 0, result, 0);
            return result[0];
        }

        private  void findSubsetSum(int[] nums, int sum, int index, Boolean[] result, int tempSum){
            if(result[0]){
                return;
            }
            if(index == nums.length){
                return;
            }

            if(tempSum == sum){
                result[0] = true;
                return;
            }
            findSubsetSum(nums, sum, index+1, result, tempSum+nums[index]);
            findSubsetSum(nums, sum, index+1, result, tempSum);
        }

    }
}
