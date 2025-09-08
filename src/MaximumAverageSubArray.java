package src;

// time complexity O(n)
// space complexity O(1)
public class MaximumAverageSubArray {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            sum = sum + nums[i];
            if(i+1 == k){
                if(sum>max){
                    max = sum;
                }
            } else if(i+1>k) {
                sum = sum-nums[i-k];
                if(sum>max){
                    max = sum;
                }
            }
        }
        double result = (double)max/(double)k;
        return result;
    }
}
