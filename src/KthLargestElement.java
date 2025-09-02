package src;

import java.util.PriorityQueue;

public class KthLargestElement {
        public int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
            for(int i=0;i<nums.length;i++){
                queue.offer(nums[i]);
                if(queue.size()>k){
                    queue.poll();
                }
            }
            return queue.peek();
        }
}
