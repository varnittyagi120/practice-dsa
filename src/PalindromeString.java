package src;

import java.util.Scanner;

public class PalindromeString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        System.out.println("String is palindrome or not : "+checkStringIsPalindrome(input, 0, input.length()-1));
    }

    private static boolean  checkStringIsPalindrome(String input, int l, int r){
        if(l>=r){
            return true;
        }

        if(input.charAt(l)!=input.charAt(r)){
            return false;
        }
        return checkStringIsPalindrome(input, l+1, r-1);
    }
}
