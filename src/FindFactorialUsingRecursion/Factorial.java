package src.FindFactorialUsingRecursion;

import java.util.Scanner;

//5
//Answer : 5*4*3*2*1 = 120
public class Factorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        for(int i=1;i<=input;i++){
            System.out.println(fibo(i));
        }
    }

    private static int fibo(int number){
        if(number==1 || number==2){
            return 1;
        }
        return fibo(number-1)+fibo(number-2);
    }
}
