package src;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PalindromePartitioning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.next();
        List<List<String>> result = new ArrayList<>();
        List<String> tempString = new ArrayList<>();
        findPartition(0, inputString, result, tempString);
        for (List<String> stringList : result) {
            System.out.println(stringList);
        }
    }

    private static void findPartition(int index, String inputString, List<List<String>> result, List<String> tempString){
        if(index==inputString.length()){
            result.add(new ArrayList<>(tempString));
            return;
        }

        for(int i = index ;i<inputString.length();i++){
            if(isPalindrome(inputString, index, i)){
                tempString.add(inputString.substring(index, i+1));
                findPartition(i+1, inputString, result, tempString);
                tempString.remove(tempString.size()-1);
            }
        }
    }

    private static boolean isPalindrome(String str, int start, int end) {
        while(start<end){
            if(str.charAt(start) != str.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
