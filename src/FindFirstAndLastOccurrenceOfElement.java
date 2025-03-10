package src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FindFirstAndLastOccurrenceOfElement {
    public static void main(String[] args){
        List<Integer> listOfIntegers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of an array");
        int sizeOfAnArray =  scanner.nextInt();
        System.out.println("Enter Numbers");
        for(int i=0;i<sizeOfAnArray;i++){
            int inputNumber = scanner.nextInt();
            listOfIntegers.add(inputNumber);
        }
        Collections.sort(listOfIntegers);
        System.out.println("Enter Target");
        int target = scanner.nextInt();
        List<Integer> result = new ArrayList<>();
        findFirstOccurrence(target, listOfIntegers, result);
        if (listOfIntegers.size()==0) {
            System.out.println(-1);
        } else {
            findLastOccurrence(target, listOfIntegers, result);
        }
        System.out.println(result);
    }

    private static void findLastOccurrence(int target, List<Integer> listOfIntegers, List<Integer> result) {
        int low = 0;
        int high = listOfIntegers.size()-1;
        while(low<=high){
                int mid = low + ((high-low)/2);
                if(target == listOfIntegers.get(mid) && (mid == listOfIntegers.size()-1 || listOfIntegers.get(mid) != listOfIntegers.get(mid+1))){
                    result.add(mid);
                    break;
                } else if(target<=listOfIntegers.get(mid)){
                    high = mid+1;
                } else if(target>listOfIntegers.get(mid)){
                    low = mid-1;
                }
            }
    }

    private static void findFirstOccurrence(int target, List<Integer> integerList, List<Integer> result) {
        int low = 0;
        int high = integerList.size()-1;
        while(low<=high){
            int mid = low + ((high-low)/2);
            if(target == integerList.get(mid) && (mid == 0 || integerList.get(mid) != integerList.get(mid-1))){
                result.add(mid);
                break;
            } else if(target>integerList.get(mid)){
                low = mid+1;
            } else if(target<=integerList.get(mid)){
                high = mid-1;
            }
        }
    }


}
//0 1 2 3 4 5 6
//1 3 3 3 4 4 5