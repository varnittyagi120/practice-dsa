package src;

public class CheckSubsetSum {

    public static void main(String[] args) {
        int[] nums = {2, 3, 1};
        boolean[] result = new boolean[1];
        result[0] = false;
        System.out.println("result "+subsetSumPresent(nums, 0, 0,  0));
    }

    private static boolean subsetSumPresent(int[] arr, int sum, int index, int currentSum){
        if(index==arr.length){
            return sum==currentSum ? true : false;
        }
        boolean include = subsetSumPresent(arr, sum, index+1,  currentSum+arr[index]);
        boolean exclude = subsetSumPresent(arr, sum, index+1,  currentSum);
        return include || exclude;
    }
}
