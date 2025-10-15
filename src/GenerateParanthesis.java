package src;

import java.util.ArrayList;
import java.util.List;

//time complexity O(Cn*n)
//space complexity O(Cn*n)

public class GenerateParanthesis {
        public List<String> generateParenthesis(int n) {
            List<String> result = new ArrayList<>();
            generateAllParenthesis(n, n, new StringBuilder(), result);
            return result;
        }

        private void generateAllParenthesis(int open, int close, StringBuilder str, List<String> result){
            if(open==0 && close==0){
                result.add(str.toString());
                return;
            }

            if(open>0){
                str.append('(');
                generateAllParenthesis(open-1, close, str, result);
                str.deleteCharAt(str.length()-1);

            }

            if(close>open){
                str.append(')');
                generateAllParenthesis(open, close-1, str, result);
                str.deleteCharAt(str.length()-1);
            }
        }
}
