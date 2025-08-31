package src;

public class CeilInSortedArray {
    public int findCeil(int[] arr, int x) {
        // code here
        int start = 0;
        int end = arr.length-1;
        int result = -1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(x<=arr[mid]){
                result = mid;
                end = mid-1;
            } else if(arr[mid]<x) {
                start = mid+1;
            }
        }
        return result;
    }
}
