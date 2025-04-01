package src.removenthnodefromend;

import java.util.Scanner;

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

    private static void addElements(LinkedList linkedList, int data){
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


    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        addElements(linkedList, 10);
        addElements(linkedList, 20);
        addElements(linkedList, 30);
        /*addElements(linkedList, 40);
        addElements(linkedList, 50);*/
        iterateLinkedList(linkedList);
        System.out.println("Please enter nth index");
        Scanner scanner = new Scanner(System.in);
        int nthIndexFromEnd = scanner.nextInt();
        int count = coutNumberOfElements(linkedList);
        int nthNodeFromStarting = (count-nthIndexFromEnd)+1;
        removeNthIndexValueFromEnd(linkedList, nthNodeFromStarting);
        iterateLinkedList(linkedList);
    }

    private static int coutNumberOfElements(LinkedList linkedList) {
       Node currentNode = linkedList.head;
       int count = 0;
       while(currentNode!=null){
            count++;
            currentNode = currentNode.next;
       }
       return count;
    }


    private static void removeNthIndexValueFromEnd(LinkedList linkedList, int index) {
        if(index==1){
            linkedList.head = linkedList.head.next;
            return;
        }
      int currentNodeCount = 1;
      Node currentNode = linkedList.head;
      Node previousNode = linkedList.head;
      while(index!=currentNodeCount){
          previousNode = currentNode;
          currentNode = currentNode.next;
          currentNodeCount++;
      }
      if(currentNode.next==null){
          previousNode.next = null;
      } else {
          previousNode.next = currentNode.next;
      }
    }
}
