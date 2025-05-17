package src.CombinationSumTwo;

import java.util.*;

public class CombinationSumTwoSolution {
    public static void main(String[] args) {
        int[] candidates = {2,5,2,1,2};
        Scanner scanner = new Scanner(System.in);
        int target = scanner.nextInt();
        List<List<Integer>> listOfInteger = new ArrayList<>();
        findCombinationSum(candidates, new ArrayList<>(), 0, new HashSet<>(), 0, listOfInteger, target);
        for (List<Integer> integerList : listOfInteger) {
            System.out.println(integerList);
        }
    }

    private static void findCombinationSum(int[] candidates, List<Integer> listOfInteger, int l, HashSet<String> hashSet, int sum, List<List<Integer>> result, int target){
         if(l==candidates.length){
             if(sum == target){
                 List<Integer> tempList = new ArrayList<>(listOfInteger);
                 Collections.sort(tempList);
                 if(!hashSet.contains(tempList.toString())){
                     hashSet.add(tempList.toString());
                     result.add(tempList);
                 }
             }
             return;
         }
         listOfInteger.add(candidates[l]);
         findCombinationSum(candidates, listOfInteger, l+1, hashSet, sum+candidates[l], result, target);
         listOfInteger.remove(listOfInteger.size()-1);
         findCombinationSum(candidates, listOfInteger, l+1, hashSet, sum, result, target);
    }
}
