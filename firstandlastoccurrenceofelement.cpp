class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        vector<int> result;
        int isElementPresent = isElementExist(nums, target); 
        if(isElementPresent==-1){
            result.push_back(-1);
            result.push_back(-1);
            return result;
        }
        int findLastOccurrence1 = findLastOccurrence(nums, target);
        int findFirstOccurrence1 = findFirstOccurrence(nums, target);
        result.push_back(findFirstOccurrence1);
        result.push_back(findLastOccurrence1);
        return result;
    }
    
    int isElementExist(vector<int>& v, int x){
         int l = 0;
         int r = v.size()-1;
         while(l<=r){
            int mid = l+((r-l)/2);
            if(v[mid]==x){
              return x;
            } else if(v[mid]<x){
                l = mid+1;
            } else if(v[mid]>x){
                r = mid-1;
            }
         }
         return -1;
    }

    int findLastOccurrence(vector<int>& v, int x){
            int l = 0;
            int r = v.size()-1;
            while(l<=r){
                int mid = l+((r-l)/2);
                if((mid==v.size()-1 && v[mid]==x) || (mid!=v.size()-1 && v[mid]!=v[mid+1] && v[mid]==x)) {
                    return mid;
                } else if(x<v[mid]) {
                    r = mid-1;
                } else {
                    l = mid+1;
                }
            }
            return -1;
    }

    int findFirstOccurrence(vector<int>& v, int x){
            int l = 0;
            int r = v.size()-1;
            while(l<=r){
                int mid = l+((r-l)/2);
                if((mid==0 && v[mid]==x) || (mid!=0 && v[mid]!=v[mid-1] && v[mid]==x)) {
                    return mid;
                } else if(v[mid]<x) {
                    l = mid+1;
                } else {
                    r = mid-1;
                }
            }
            return -1;
    }
};