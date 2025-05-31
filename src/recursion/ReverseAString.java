package src.recursion;

import java.util.Scanner;

public class ReverseAString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.next();
        System.out.println(reverseAString(inputString, 0, inputString.length()-1));
    }

    private static String reverseAString(String inputString, int start, int end){
        if(start>end){
            return inputString;
        }
        inputString = swapIndexes(inputString, start, end);
        return reverseAString(inputString, start+1, end-1);
    }

    private static String swapIndexes(String inputString, int start, int end) {
        char[] charArray = inputString.toCharArray();
        char temp = charArray[start];
        charArray[start] = charArray[end];
        charArray[end] = temp;
        return new String(charArray);
    }
}
