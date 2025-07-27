package src;

import java.util.ArrayList;
import java.util.List;

public class PascalTringleSolution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> innerArray = new ArrayList<>();
        innerArray.add(1);
        result.add(innerArray);
        if(numRows==1){
            return result;
        }
        for(int i=1;i<numRows;i++){
            int[] innerList = new int[i+1];
            innerList[0]=1;
            innerList[i]=1;
            int k = 1;
            i=3
            if(k<i){
                List<Integer> previousRowElements = result.get(i-1);
                for(int j=0;j<previousRowElements.size();j++){
                    if(j!=previousRowElements.size()-1){
                        int sum =  previousRowElements.get(j)+previousRowElements.get(j+1);
                        innerList[k]= sum;
                        k++;
                    }
                }
            }
            result.add(getArrayList(innerList));
        }
        return result;
    }

    private List<Integer> getArrayList(int[] innerList){
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<innerList.length;i++){
            result.add(innerList[i]);
        }
        return result;
    }
}
