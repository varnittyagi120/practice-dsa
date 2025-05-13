package src.reverseastring;

import java.util.Scanner;

public class ReverseAString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        char[] charArray = input.toCharArray();
        System.out.println(reverseAString(charArray, 0, input.length()-1));
    }

    private static String reverseAString(char[] charArray, int l, int r){
        if(l>=r){
            String result = new String(charArray);
            return result;
        }
        char tempChar = charArray[l];
        charArray[l] = charArray[r];
        charArray[r] = tempChar;
        return reverseAString(charArray, l+1, r-1);
    }
}
