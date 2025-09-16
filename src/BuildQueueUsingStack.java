package src;

import java.util.Stack;

public class BuildQueueUsingStack {
    Stack<Integer> stack = null;
    Stack<Integer> stack1 = null;
    public BuildQueueUsingStack() {
        this.stack = new Stack<>();
        this.stack1 = new Stack<>();
    }

    public void push(int x) {
        if(stack.isEmpty() && stack1.isEmpty()){
            stack.push(x);
        } else if(!stack.isEmpty() && stack1.isEmpty()){
            stack.push(x);
        } else if(stack.isEmpty() && !stack1.isEmpty()){
            while(!stack1.isEmpty()){
                stack.push(stack1.peek());
                stack1.pop();
            }
            stack.push(x);
        }
    }

    public int pop() {
        return checkTopOrPopPeek(true);
    }

    public int peek() {
        return checkTopOrPopPeek(false);
    }

    public boolean empty() {
        return (stack.isEmpty() && stack1.isEmpty())?true:false;
    }

    private int checkTopOrPopPeek(boolean flag){
        int result = -1;
        int j = 1;
        if(!stack.isEmpty()){
            int s1 = stack.size();
            while(!stack.isEmpty()){
                result = stack.peek();
                System.out.println(result);
                if(flag){
                    if(j!=s1){
                        stack1.push(result);
                    }
                } else {
                    stack1.push(result);
                }
                stack.pop();
                j++;
            }
        } else if(!stack1.isEmpty()){
            int s2 = stack1.size();
            if(flag==true){
                result = stack1.peek();
                stack1.pop();
            } else {
                result = stack1.peek();
            }
        }
        return result;
    }
}
