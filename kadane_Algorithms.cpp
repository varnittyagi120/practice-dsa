class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int globalMaximum = INT_MIN;
        int currentMaximum = 0;
        for(int i=0;i<nums.size();i++){
            if(nums[i]<0){
                currentMaximum += nums[i];
                if(currentMaximum<0){
                    currentMaximum=0;
                }
                if(nums[i]>globalMaximum){
                    globalMaximum = nums[i];
                }
            } else {
                currentMaximum += nums[i];
                if(currentMaximum>globalMaximum){
                    globalMaximum = currentMaximum;
                }
            }
        }
        
        return globalMaximum;
    }
};