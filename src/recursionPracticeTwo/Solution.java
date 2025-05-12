package src.recursionPracticeTwo;

import java.util.Scanner;

//print numbers in descending order
//5, 4, 3, 2, 1
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Number : ");
        int number = scanner.nextInt();
        printNumbers(number);
    }

    private static void printNumbers(int number){
        if(number==0){
            return;
        }
        System.out.println(number);
        number = number-1;
        printNumbers(number);
    }
}
