package src;

import java.util.Stack;

//time and space complexity is O(N)
public class ElvaluateReversePolishNotion {
        public int evalRPN(String[] token) {
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < token.length; i++) {
                if (token[i].equals("*") || token[i].equals("+") || token[i].equals("-") || token[i].equals("/")) {
                    int topElement = stack.peek();
                    stack.pop();
                    int secondTopElement = stack.peek();
                    stack.pop();
                    if (token[i].equals("*")) {
                        int result = secondTopElement * topElement;
                        stack.push(result);
                    } else if (token[i].equals("/")) {
                        int result = secondTopElement / topElement;
                        stack.push(result);
                    } else if (token[i].equals("+")) {
                        int result = secondTopElement + topElement;
                        stack.push(result);
                    } else if (token[i].equals("-")) {
                        int result = secondTopElement - topElement;
                        stack.push(result);
                    }
                } else {
                    stack.push(Integer.parseInt(token[i]));
                }
            }
            return stack.pop();
        }
}
