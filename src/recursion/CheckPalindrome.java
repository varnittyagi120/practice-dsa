package src.recursion;

import java.util.Scanner;

public class CheckPalindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.next();
        System.out.println(isPalindrome(inputString, 0, inputString.length()-1));
    }

    private static boolean isPalindrome(String str, int start, int end){
        if(start>end){
            return true;
        }

        if(str.charAt(start)!=str.charAt(end)){
            return false;
        }
        return isPalindrome(str, start+1, end-1);
    }
}
