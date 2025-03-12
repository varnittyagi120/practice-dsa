package src;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindWords {
    public int countCharacters(String[] words, String chars) {
        int result = 0;
        for(int i=0;i<words.length;i++){
            int[] characterSumArray = new int[26];
            getArrayOfCharacterCount(characterSumArray, chars);
            String tempString = words[i];
            boolean flag = true;
            for(int j=0;j<tempString.length();j++){
                int number = tempString.charAt(j)-97;
                if(characterSumArray[number]>0){
                    int count1 = characterSumArray[number];
                    count1--;
                    characterSumArray[number] = count1;
                } else {
                    flag = false;
                    break;
                }
            }
            if(flag){
                result+=tempString.length();
            }
        }
        return result;
    }

    private void getArrayOfCharacterCount(int[] characterSumArray, String chars){

        for(int i=0;i<chars.length();i++){
            int number = chars.charAt(i)-97;
            int existingNumberCount = characterSumArray[number];
            existingNumberCount++;
            characterSumArray[number] = existingNumberCount;
        }
    }


}
