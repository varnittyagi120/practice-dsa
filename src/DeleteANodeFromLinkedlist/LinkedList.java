package src.DeleteANodeFromLinkedlist;

public class LinkedList {
    public Node head;
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    private void addElement(LinkedList linkedList, int data){
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

    private void iterateOverLinkedList(LinkedList linkedList){
        Node currentNode = linkedList.head;
        while(currentNode!=null){
            System.out.println(currentNode.data);
            currentNode = currentNode.next;
        }
    }

    private static void removeGivenNode(LinkedList linkedList, int data){
        Node currentNode = linkedList.head;
        Node previousNode = null;
        while (currentNode.next!=null){
            if(currentNode.data==data){
                if(previousNode==null){
                    linkedList.head = linkedList.head.next;
                } else {
                    previousNode.next=currentNode.next;
                }
            }
            previousNode = currentNode;
            currentNode = currentNode.next;
        }
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.addElement(linkedList, 4);
        linkedList.addElement(linkedList, 5);
        linkedList.addElement(linkedList, 1);
        linkedList.addElement(linkedList, 9);
        //linkedList.addElement(linkedList, 50);
        linkedList.iterateOverLinkedList(linkedList);
        removeGivenNode(linkedList, 5);
        System.out.println("new linked list");
        linkedList.iterateOverLinkedList(linkedList);
    }
}
