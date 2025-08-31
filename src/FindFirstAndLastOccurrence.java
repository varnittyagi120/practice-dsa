package src;

public class FindFirstAndLastOccurrence {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        int start = 0;
        int end = nums.length-1;
        int left = -1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(target==nums[mid]){
                left = mid;
                end = mid-1;
            } else if(nums[mid]<target){
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        start = 0;
        end = nums.length-1;
        int right = -1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(nums[mid] == target){
                right = mid;
                start = mid+1;
            } else if(target < nums[mid]){
                end = mid-1;
            } else {
                start = mid+1;
            }
        }

        result[0] = left;
        result[1] = right;
        return result;
    }
}
