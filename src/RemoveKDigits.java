package src;

import java.util.Stack;

public class RemoveKDigits {
        public String removeKdigits(String num, int k) {
            Stack<Character> stack = new Stack<>();
            for(int i=0;i<num.length();i++){
                while(!stack.isEmpty() && k>0 && (int)num.charAt(i) < (int)stack.peek()){
                    stack.pop();
                    k--;
                }
                stack.push(num.charAt(i));
            }
            while(k>0 && !stack.isEmpty()){
                k--;
                stack.pop();
            }
            if(stack.isEmpty()){
                return "0";
            }
            StringBuilder str = new StringBuilder();
            while(!stack.isEmpty()){
                str.append(stack.peek());
                stack.pop();
            }

            while(str.length()>0 && str.charAt(str.length()-1)=='0'){
                str.deleteCharAt(str.length()-1);
            }
            if(str.length()>0){
                return "0";
            }
            str.reverse();
            return str.toString();
        }
}
