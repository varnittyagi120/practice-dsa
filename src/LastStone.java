package src;

import java.util.Collections;
import java.util.PriorityQueue;

public class LastStone {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<stones.length;i++){
            queue.add(stones[i]);
        }
        int result = 0;
        while(!queue.isEmpty()){
            Integer currentElement = queue.poll();
            if(!queue.isEmpty()){
                Integer top = queue.poll();
                int diff = Math.abs(top-currentElement);
                result = diff;
                queue.add(diff);
            } else {
                result = currentElement;
            }
        }
        return result;
    }
    //time complexity will be O(n log(n))
    //space complexity will be O(n)
}
