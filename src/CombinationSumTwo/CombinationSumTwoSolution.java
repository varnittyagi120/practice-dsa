package src.CombinationSumTwo;

import java.util.*;

public class CombinationSumTwoSolution {
    public static void main(String[] args) {
        System.out.println("Enter Target : ");
        int[] candidates = {10,1,2,7,6,1,5};
        Scanner scanner = new Scanner(System.in);
        int target = scanner.nextInt();
        List<List<Integer>> listOfInteger = new ArrayList<>();
        Arrays.sort(candidates);
        for(int i=0;i<candidates.length;i++){
            System.out.println("candidates : "+candidates[i]);
        }
        findCombinationSumTwoSolution(candidates, 0,  listOfInteger, new ArrayList<>(), target);
        for (List<Integer> integerList : listOfInteger) {
            System.out.println(integerList);
        }
    }


    private static void findCombinationSumTwoSolution(int[] arr, int index, List<List<Integer>> result, List<Integer> tempArray, int target) {
        if(target == 0){
            result.add(new ArrayList<>(tempArray));
            return;
        }

        for(int i = index; i<arr.length; i++){
            if(i>index && arr[i]==arr[i-1]){
                continue;
            }
            if(arr[i]>target){
                break;
            }
            tempArray.add(arr[i]);
            findCombinationSumTwoSolution(arr, i+1, result, tempArray, target-arr[i]);
            tempArray.remove(tempArray.size()-1);
        }
    }
}
