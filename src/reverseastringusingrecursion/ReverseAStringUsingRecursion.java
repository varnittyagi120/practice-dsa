package src.reverseastringusingrecursion;

import java.util.Scanner;

public class ReverseAStringUsingRecursion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        StringBuilder stringBuilder = new StringBuilder("");
        System.out.println(reverseAString(input.length(), input, stringBuilder));
    }

    private static String reverseAString(int n, String input, StringBuilder answer){
        if(n==0){
            return answer.toString();
        }
        n = n-1;
        answer.append(input.charAt(n));
        reverseAString(n, input, answer);
        return answer.toString();
    }
}
