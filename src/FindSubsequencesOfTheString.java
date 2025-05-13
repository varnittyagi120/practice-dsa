package src;

import java.util.Scanner;

//print the subsequence of the string
public class FindSubsequencesOfTheString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        findSubsequenceOfAString(input, 0, "");
    }

    private static void findSubsequenceOfAString(String input, int i, String subsequence){
        if(i==input.length()){
            System.out.println(subsequence);
            return;
        }
        String tempString = subsequence+input.charAt(i);
        findSubsequenceOfAString(input, i+1, tempString);
        findSubsequenceOfAString(input, i+1, subsequence);

    }
}
