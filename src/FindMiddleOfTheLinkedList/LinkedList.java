package src.FindMiddleOfTheLinkedList;

import java.sql.SQLOutput;

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


    private static void findMiddleOfAnArray(LinkedList linkedList){
        Node slowPointer = linkedList.head;
        Node fastPointer = linkedList.head;
        while(fastPointer!=null && fastPointer.next!=null){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
            System.out.println(slowPointer.data);
        }
        System.out.println(slowPointer.data);
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        addElement(linkedList, 10);
        addElement(linkedList, 20);
//        addElement(linkedList, 30);
//        addElement(linkedList, 40);
//        addElement(linkedList, 50);
//        addElement(linkedList, 60);
        iterateLinkedList(linkedList);
        findMiddleOfAnArray(linkedList);
    }
}
