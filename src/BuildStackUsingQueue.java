package src;

import java.util.LinkedList;
import java.util.Queue;

public class BuildStackUsingQueue {
    Queue<Integer> queue = null;
    public BuildStackUsingQueue() {
        this.queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.add(x);
    }

    public int pop() {
        return popLastElement();
    }

    public int top() {
        return frontElement();
    }

    public boolean empty() {
        return queue.isEmpty();
    }

    private int popLastElement(){
        int result = -1;
        int size = queue.size();
        int count = 1;
        while(!queue.isEmpty()){
            int frontElement = queue.peek();
            if(size==count){
                result = frontElement;
                queue.poll();
                break;
            } else {
                queue.poll();
                queue.add(frontElement);
            }
            count++;
        }
        return result;
    }

    private int frontElement(){
        int result = -1;
        int size = queue.size();
        int count = 1;
        while(!queue.isEmpty()){
            int frontElement = queue.peek();
            if(size==count){
                result = frontElement;
                queue.poll();
                queue.add(frontElement);
                break;
            } else {
                queue.poll();
                queue.add(frontElement);
            }

            count++;
        }
        return result;
    }
}
