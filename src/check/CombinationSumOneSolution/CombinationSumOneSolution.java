package src.check.CombinationSumOneSolution;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CombinationSumOneSolution {
    public static void main(String[] args) {
        int[] array = {2,3,6,7};
        Scanner scanner = new Scanner(System.in);
        int target = scanner.nextInt();
        List<List<Integer>> listOfIntegers = new ArrayList<>();
        findCombinationSumSolution(array, 0, listOfIntegers, new ArrayList<>(), target);
        for (List<Integer> integerList : listOfIntegers) {
            System.out.println(integerList);
        }
    }

    private static void findCombinationSumSolution(int[] arr, int ind, List<List<Integer>> result, List<Integer> tempSubset, int target){
        if(ind==arr.length){
            if(target==0){
                result.add(new ArrayList<>(tempSubset));
            }
            return;
        }

        if(arr[ind]<=target){
            tempSubset.add(arr[ind]);
            findCombinationSumSolution(arr, ind, result, tempSubset, target-arr[ind]);
            tempSubset.remove(tempSubset.size()-1);
        }
        findCombinationSumSolution(arr, ind+1, result, tempSubset, target);
    }
}
