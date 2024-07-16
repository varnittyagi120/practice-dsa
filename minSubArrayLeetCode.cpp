class Solution {
public:
    int minSubArrayLen(int target, vector<int>& nums) {
        int min = INT_MAX;
        int sum = 0;
        int end = 0;
        int start = 0;
        while(end<nums.size()){
            sum += nums[end];
            while(sum>=target){
                sum -= nums[start];
                int temp = (end-start)+1;
                start++;
                if(temp<min){
                    min = temp;
                }
            }
            end++;
        }
        return min==INT_MAX ? 0 : min;
    }
};