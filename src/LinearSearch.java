package src;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LinearSearch {
    public static void main(String[] args) {
        //Input
        List<Integer> integerList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter size of an array : ");
        int size = scanner.nextInt();
        System.out.println("Enter Numbers :");
        for(int i=0;i<size;i++){
            int number = scanner.nextInt();
            integerList.add(number);
        }
        System.out.println("Enter target :");
        int target = scanner.nextInt();
        findGivenTargetInAnArray(integerList, target);
    }

    private static void findGivenTargetInAnArray(List<Integer> arrayList, int target) {
        boolean flagIndecator = true;
        for (int i=0;i<arrayList.size();i++) {
            if(arrayList.get(i)==target){
                System.out.println("Number found at given index "+i);
                flagIndecator = false;
            }
        }
        if(flagIndecator){
            System.out.println("Given number did not find in the list");
        }
    }
}
