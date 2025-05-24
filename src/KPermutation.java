package src;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KPermutation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Number : ");
        int inputNumber = scanner.nextInt();
        System.out.println("Enter Kth number : ");
        int kthElement = scanner.nextInt();
        System.out.println(findKthPermutation(inputNumber, kthElement));;
    }

    private static String findKthPermutation(int inputNumber, int kthElement) {
        int fact = 1;
        StringBuilder result = new StringBuilder();
        List<Integer> integerList = new ArrayList<>();
        for(int i=1;i<inputNumber;i++){
            fact = fact*i;
            integerList.add(i);
        }
        integerList.add(inputNumber);
        kthElement = kthElement-1;
        while(true){
            result.append(integerList.get(kthElement/fact));
            integerList.remove(kthElement/fact);
            if(integerList.size()==0){
                break;
            }
            kthElement = kthElement % fact;
            fact = fact/integerList.size();
        }
        return result.toString();
    }
}
