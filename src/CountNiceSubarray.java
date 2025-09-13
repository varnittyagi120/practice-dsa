package src;

public class CountNiceSubarray {
    public int numberOfSubarrays(int[] nums, int k) {
        int result = 0;
        int left = 0;
        int start = -1;
        int oddNumbersCount = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2!=0){
                if(start==-1){
                    start = i;
                }
                oddNumbersCount++;
            }

            if(k<oddNumbersCount){
                left = start;
                start++;
                while(nums[start]%2==0){
                    start++;
                }
                oddNumbersCount--;
            }

            if(k==oddNumbersCount){
                if(start-left==0){
                    result+=1;
                } else {
                    if(nums[left]%2==0){
                        result += start-left+1;
                    } else {
                        result += start-left;
                    }
                }
            }
        }
        return result;
    }
}
