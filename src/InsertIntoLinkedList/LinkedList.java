package src.InsertIntoLinkedList;

public class LinkedList {
     Node head;
     static class Node {
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
         System.out.println("Linked List Elements : ");
         Node currentNode = linkedList.head;
         while (currentNode.next!=null){
             System.out.println(currentNode.data+" ");
             currentNode = currentNode.next;
         }
     }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        addElement(linkedList, 10);
        addElement(linkedList, 20);
        addElement(linkedList, 30);
        addElement(linkedList, 40);
        addElement(linkedList, 50);
        iterateLinkedList(linkedList);
    }
}
