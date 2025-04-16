package src.check.intesection.of.two.linkedlist;

public class Solution {
      public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) {
              val = x;
              next = null;
          }
     }
     public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode currentNodeOne = headA;
            ListNode currentNodeTwo = headB;
            while(currentNodeOne!=currentNodeTwo){
                currentNodeOne = (currentNodeOne==null)?headB:currentNodeOne.next;
                currentNodeTwo = (currentNodeTwo==null)?headA:currentNodeTwo.next;
            }
            return currentNodeOne;
      }
    
}
