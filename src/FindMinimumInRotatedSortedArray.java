package src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Size of the array");
        int sizeOfTheArray = scanner.nextInt();
        List<Integer> integerList = new ArrayList<>();
        for (int i=0;i<sizeOfTheArray;i++){
            int element = scanner.nextInt();
            integerList.add(element);
        }
        System.out.println("result "+findMinimumElement(integerList));;
    }

    private static int findMinimumElement(List<Integer> integerList) {
        if(integerList.size()==1){
            return integerList.get(0);
        }
        int low = 0;
        int high = integerList.size()-1;
        while(low<=high){
            int mid = low + ((high-low)/2);
            if(((mid!=0 && mid!=integerList.size()-1)
                    && (integerList.get(mid)<integerList.get(mid-1) && integerList.get(mid)<integerList.get(mid+1)))
               || (mid==integerList.size()-1 && integerList.get(mid)<integerList.get(mid-1))){
                return integerList.get(mid);
            } else if(integerList.get(0)<=integerList.get(mid)){
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return integerList.get(0);
    }
}

//0   1  2  3
// 11 12 13 14
//4 5 6 7 0 1 2