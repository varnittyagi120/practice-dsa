package src;

import java.util.*;
// time complexity O(klog(k))
//space complexity O(k)
public class FindKPairWithSmallestSum {
    public class Pair{
        int sum;
        int idx1;
        int idx2;
        Pair(int sum, int idx1, int idx2){
            this.sum = sum;
            this.idx1 = idx1;
            this.idx2 = idx2;
        }

        public int getSum(){
            return this.sum;
        }

        public int getIdx1(){
            return this.idx1;
        }

        public int getIdx2(){
            return this.idx2;
        }
    }
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.sum, b.sum));
        Set<String> checker = new HashSet<>();
        Pair pair = new Pair(nums1[0]+nums2[0], 0, 0);
        pq.add(pair);
        checker.add("0,0");
        while(!pq.isEmpty() && k>0){
            List<Integer> tempArray = new ArrayList<>();
            Pair topPair = pq.poll();
            k--;
            tempArray.add(nums1[topPair.getIdx1()]);
            tempArray.add(nums2[topPair.getIdx2()]);
            if(topPair.getIdx1()+1<nums1.length && !checker.contains((topPair.getIdx1()+1)+","+topPair.getIdx2())){
                Pair pair1 = new Pair(nums1[(topPair.getIdx1()+1)]+nums2[topPair.getIdx2()], (topPair.getIdx1()+1), topPair.getIdx2());
                checker.add((topPair.getIdx1()+1)+","+topPair.getIdx2());
                pq.add(pair1);
            }

            if(topPair.getIdx2()+1<nums2.length && !checker.contains(topPair.getIdx1()+","+(topPair.getIdx2()+1))){
                Pair pair2 = new Pair(nums1[topPair.getIdx1()]+nums2[(topPair.getIdx2()+1)], topPair.getIdx1(), (topPair.getIdx2()+1));
                checker.add(topPair.getIdx1()+","+(topPair.getIdx2()+1));
                pq.add(pair2);
            }
            result.add(tempArray);
        }

        return result;
    }
}
