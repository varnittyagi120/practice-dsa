package src.find.a.cycle.into.linkedlist;

public class Solution {
    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
    public boolean hasCycle(ListNode head) {
        ListNode currentNode = head;
        ListNode secondNode = head;
        int count=0;
        while((currentNode!=null && (secondNode!=null && secondNode.next!=null))){
            currentNode = currentNode.next;
            secondNode = secondNode.next.next;
            if(currentNode==secondNode){
                return true;
            }
        }
        return false;
    }
}
