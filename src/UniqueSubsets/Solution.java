package src.UniqueSubsets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int[] input = {1,2,2};
        HashSet<String> hashSet = new HashSet<>();
        findUniqueSubset(input, 0, new ArrayList<>(), hashSet);
        for (String str : hashSet) {
            System.out.println(str);
        }
    }

    private static void findUniqueSubset(int[] input, int l, List<Integer> listOfInteger, HashSet<String> setOfInteger){
         if(l==input.length){
             Collections.sort(listOfInteger);
             setOfInteger.add(listOfInteger.toString());
             return;
         }
         listOfInteger.add(input[l]);
         findUniqueSubset(input, l+1, listOfInteger, setOfInteger);
         listOfInteger.remove(listOfInteger.size()-1);
         findUniqueSubset(input, l+1, listOfInteger, setOfInteger);
    }
}
