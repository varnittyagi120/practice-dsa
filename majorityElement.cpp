class Solution {
public:
    int majorityElement(vector<int>& nums) {
    int frequentElement = nums[0];
   int frequentElementcount = 1;
   for(int i=1;i<nums.size();i++){
      if(nums[i]==frequentElement){
         frequentElementcount++;
      } else if(nums[i]!=frequentElement && frequentElementcount!=0){
         frequentElementcount--;
      } else if(nums[i]!=frequentElement && frequentElementcount==0) {
           frequentElement = nums[i];
           frequentElementcount++;
      }
   }

   int countOfGlobalElement = 0;
   for(int i=0;i<nums.size();i++){
      if(frequentElement==nums[i]){
        countOfGlobalElement++;
      }
   }        
   if(countOfGlobalElement>(nums.size()/2)){
      return frequentElement;
   }
   return -1;
    }
};