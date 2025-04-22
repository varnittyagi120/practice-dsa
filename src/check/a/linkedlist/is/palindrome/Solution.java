package src.check.a.linkedlist.is.palindrome;

class Solution {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode firstNodeOfSecondHalf = slow.next;
        slow.next = null;
        ListNode currentNode = firstNodeOfSecondHalf;
        ListNode prev = null;
        while(currentNode!=null){
            ListNode tempNode = currentNode;
            currentNode = currentNode.next;
            tempNode.next = prev;
            prev = tempNode;
        }

        ListNode firstLinkedList = head;
        ListNode secondLinkedList = prev;
        while(firstLinkedList!=null && secondLinkedList!=null){
            if(firstLinkedList.val!=secondLinkedList.val){
                return false;
            }
            firstLinkedList = firstLinkedList.next;
            secondLinkedList = secondLinkedList.next;
        }
        return true;
    }
}
