package src;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> result = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            result.put(nums[i], result.getOrDefault(nums[i], 0)+1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((a, b)->(a.getValue()-b.getValue()));
        for(Map.Entry<Integer, Integer> entry : result.entrySet()){
            queue.offer(entry);
            if(queue.size()>k){
                queue.poll();
            }
        }

        int[] output = new int[k];
        int i = 0;
        while(!queue.isEmpty()){
            Map.Entry<Integer, Integer> entry = queue.poll();
            output[i++] = entry.getKey();
        }
        return output;
    }
}
