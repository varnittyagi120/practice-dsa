package src.UniqueSubsets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int[] input = {3,2,1};
        HashSet<String> hashSet = new HashSet<>();
        findUniqueSubset(input, 0, new ArrayList<>(), hashSet);
        for (String str : hashSet) {
            System.out.println(str);
        }
    }

    private static void findUniqueSubset(int[] input, int l, List<Integer> listOfInteger, HashSet<String> setOfInteger){
         if(l==input.length){
             List<Integer> tempList = new ArrayList<>(listOfInteger);
             Collections.sort(tempList);
             setOfInteger.add(tempList.toString());
             return;
         }
         listOfInteger.add(input[l]);
         findUniqueSubset(input, l+1, listOfInteger, setOfInteger);
         listOfInteger.remove(listOfInteger.size()-1);
         findUniqueSubset(input, l+1, listOfInteger, setOfInteger);
    }
}
