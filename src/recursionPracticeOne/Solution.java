package src.recursionPracticeOne;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number");
        int number = scanner.nextInt();
        printNumbers(number);
    }

    private static void printNumbers(int number){
        if(number==0){
            return;
        }
        number = number-1;
        printNumbers(number);
        System.out.println(number+1);
    }
}
