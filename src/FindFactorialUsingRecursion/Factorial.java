package src.FindFactorialUsingRecursion;

import java.util.Scanner;

//5
//Answer : 5*4*3*2*1 = 120
public class Factorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        System.out.println(findFactorial(input));
    }

    private static int findFactorial(int number){
        if(number==1){
            return 1;
        }
        return number*findFactorial(number-1);
    }
}
