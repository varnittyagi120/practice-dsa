package src;

import java.util.Scanner;

import static java.util.Collections.swap;

public class FindSubsetsOfAString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        findAllPermutations(input, 0, input.length()-1);
    }

    private static void findAllPermutations(String input, int l, int r){
        if(l==r){
            System.out.println(input);
            return;
        }
        for(int i=l;i<=r;i++){
            input = swapCharacters(input, l, i);
            findAllPermutations(input, l+1, r);
            input = swapCharacters(input, l, i);
        }
    }

    private static String swapCharacters(String input, int l, int r){
        char[] charArray = input.toCharArray();
        char tempChar = charArray[l];
        charArray[l] = charArray[r];
        charArray[r] = tempChar;
        return new String(charArray);
    }
}
