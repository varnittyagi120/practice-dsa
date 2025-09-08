package src;

public class RemoveDuplicatesFromASortedArray {
    public int removeDuplicates(int[] nums) {
        int result = 0;
        for(int i=0;i<nums.length;i++){
            if(i!=nums.length-1){
                if(nums[i]==nums[i+1]){
                    nums[i] = -200;
                }
            }
        }

        for(int i=0;i<nums.length;i++){
            if(nums[i]!=-200){
                if(i!=result){
                    nums[result] = nums[i];
                    nums[i] = -200;
                }
                result++;
            }
        }
        return result;
    }
}
