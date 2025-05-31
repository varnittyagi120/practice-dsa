package src.recursion;

import java.util.Scanner;

public class PrintFibonacciSeries {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        findFibonacciNumber(number, 0, 1);
    }

    private static void findFibonacciNumber(int number, int a, int b) {
        if(number==0){
            return;
        }
        System.out.println(a);
        findFibonacciNumber(number-1, a+b, a);
    }
}

//0 1 1 2