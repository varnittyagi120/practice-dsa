package src;

//time complexity O(2^n)
//space complexity O(n)
public class PrintSubsetSumCount {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1};
        boolean[] result = new boolean[1];
        result[0] = false;
        System.out.println("result "+subsetSumPresent(nums, 0, 0,  0, 3));
    }

    private static int subsetSumPresent(int[] arr, int sum, int index, int currentSum, int target){
        if(index==arr.length){
            return currentSum==target ? 1 : 0;
        }
        int include = subsetSumPresent(arr, sum, index+1,  currentSum+arr[index], target);
        int exclude = subsetSumPresent(arr, sum, index+1,  currentSum, target);
        return include + exclude;
    }
}

//2 3 5 7
