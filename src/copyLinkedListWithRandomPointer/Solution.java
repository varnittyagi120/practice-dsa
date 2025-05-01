package src.copyLinkedListWithRandomPointer;

public class Solution {
    public static class Node

    {
        int val;
        Node next;
        Node random;

    public Node( int val){
        this.val = val;
        this.next = null;
        this.random = null;
    }
    }


    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node currentNode = head;
        while(currentNode!=null){
            Node nextElement = currentNode.next;
            Node copiedNode = new Node(currentNode.val);
            copiedNode.next = nextElement;
            currentNode.next = copiedNode;
            currentNode = nextElement;
        }
        currentNode = head;
        while(currentNode!=null){
            Node tempNode = currentNode.next;
            if(currentNode.random==null){
                tempNode.random = null;
            } else {
                tempNode.random = currentNode.random.next;
            }

            currentNode = currentNode.next.next;
        }
        Node result = new Node(-1);
        Node copiedNode = result;
        currentNode = head;
        while(currentNode!=null){
            copiedNode.next = currentNode.next;
            copiedNode = copiedNode.next;

            currentNode.next = currentNode.next.next;
            currentNode = currentNode.next;
        }
        return result.next;
    }
}
