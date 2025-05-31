package src.recursion;

public class FindArraySum {
    public static void main(String[] args) {
        int[] inputArray = {1,2,3,4,5};
        System.out.println(findSumOfArray(inputArray, 0, 0));
    }

    private static int findSumOfArray(int[] inputArray, int index, int sum) {
        if(index == inputArray.length){
            return sum;
        }
        return findSumOfArray(inputArray, index+1, sum+inputArray[index]);
    }
}
