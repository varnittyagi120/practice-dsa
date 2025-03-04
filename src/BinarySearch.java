package src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        //input
        List<Integer> integerList = new ArrayList<>();
        System.out.println("Enter the size of an array : ");
        Scanner scanner = new Scanner(System.in);
        int sizeOfArray = scanner.nextInt();
        System.out.println("Enter the elements : ");
        for (int i=0;i<sizeOfArray;i++) {
            int element = scanner.nextInt();
            integerList.add(element);
        }
        System.out.println("Enter target element : ");
        int target = scanner.nextInt();
        Collections.sort(integerList);
        searchElement(integerList, target);
    }

    private static void searchElement(List<Integer> integerList, int target) {
        int l = 0;
        int r = integerList.size()-1;
        boolean isTargetPresent = true;
        while(l<=r){
            int mid = l+ ((r-l)/2);
           if(integerList.get(mid) == target){
               System.out.println("element found at index : "+mid);
               isTargetPresent = false;
               break;
           } else if(target < integerList.get(mid)){
               r = mid-1;
           } else if(integerList.get(mid) < target){
               l = mid+1;
           }
        }

        if(isTargetPresent){
            System.out.println("element is not present");
        }
    }


}

//0 1 2 3 4 5
//1 2 3 4 5 6
