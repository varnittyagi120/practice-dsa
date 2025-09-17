package src;

import java.util.Stack;

public class MinStack {
        Stack<Integer> stack = null;
        Stack<Integer> stack1 = null;
        public MinStack() {
            this.stack = new Stack<>();
            this.stack1 = new Stack<>();
        }

        public void push(int val) {
            stack.push(val);
            if(stack1.isEmpty()){
                stack1.push(val);
            } else {
                if(stack1.peek()>=val){
                    stack1.push(val);
                }
            }
        }

        public void pop() {
            if(stack.peek().equals(stack1.peek())){
                stack1.pop();
            }
            stack.pop();

        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return !stack1.isEmpty()?stack1.peek():-1;
        }
}
