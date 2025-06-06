package src.ReverseLinkedList;

public class LinkedList {
    Node head;
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    private static void addElement(LinkedList linkedList, int data){
        Node node = new Node(data);
        node.next = null;

        if(linkedList.head==null){
            linkedList.head = node;
        } else {
            Node currentNode = linkedList.head;
            while(currentNode.next!=null){
                currentNode = currentNode.next;
            }
            currentNode.next = node;
        }
    }

    private static void iterateLinkedList(LinkedList linkedList){
        Node currentNode = linkedList.head;
        while(currentNode!=null){
            System.out.println(currentNode.data);
            currentNode = currentNode.next;
        }
    }

    private static void revereLinkedList(LinkedList linkedList){
        Node lastNode = null;
        Node currentNode = linkedList.head;
        Node tempNode = null;
        while(currentNode!=null){
            tempNode = currentNode;
            currentNode = currentNode.next;
            tempNode.next = lastNode;
            lastNode = tempNode;
        }
        linkedList.head = lastNode;
    }
    public static void main(String[] args) {
      LinkedList linkedList = new LinkedList();
      addElement(linkedList, 10);
      addElement(linkedList, 11);
      addElement(linkedList, 12);
      addElement(linkedList, 13);
      iterateLinkedList(linkedList);
      revereLinkedList(linkedList);
      System.out.println("Print Linkedlist in reverse way : ");
      iterateLinkedList(linkedList);
    }

}

//1 -> 2 -> 3 -> 4 -> 5 -> 6

//null->
