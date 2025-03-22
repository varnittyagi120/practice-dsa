package src;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SearchInRotatedSortedArray2 {
    public boolean search(int[] nums, int target) {
            int high = nums.length-1;
            int low = 0;
            while(low<=high){
                int mid = low + ((high-low)/2);
                if(nums[mid]==target){
                    return true;
                }

                if(nums[low]==nums[mid] && nums[mid]==nums[high]){
                    low++;
                    high--;
                } else if(nums[low]<=nums[mid]){
                    if(nums[low]<=target && target<nums[mid]){
                        high = mid-1;
                    } else {
                        low = mid+1;
                    }
                } else {
                    if(nums[mid]<target && target<=nums[high]){
                        low = mid+1;
                    } else {
                        high = mid-1;
                    }
                }
            }
            return false;
        }
}
//2 3 4 5 6 7 1
//1 0 1 1 1