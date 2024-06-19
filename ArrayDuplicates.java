import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayDuplicates {
    public static void main(String[] args) {
       List<Integer> result = getListOfDuplicateElements();
       for(int i=0;i<result.size();i++) {
           System.out.println(result.get(i));
       }
    }

    private static List<Integer> getListOfDuplicateElements() {
        List<Integer> listOfIntegers = new ArrayList<>();
        listOfIntegers.add(2);
        listOfIntegers.add(3);
        listOfIntegers.add(1);
        listOfIntegers.add(2);
        listOfIntegers.add(3);
        Collections.sort(listOfIntegers);
        int top = 0;
        List<Integer> result = new ArrayList<>();
        for (int i=0;i<listOfIntegers.size();i++) {
            if(i==listOfIntegers.size()-1){
                break;
            }
            if(listOfIntegers.get(i)==listOfIntegers.get(i+1)){
                if(result.size()==0){
                    result.add(listOfIntegers.get(i));
                } else {
                    if(listOfIntegers.get(i)!=result.get(top)){
                        result.add(listOfIntegers.get(i));
                        top++;
                    }
                }
            }
        }
        return result;
    }
}
