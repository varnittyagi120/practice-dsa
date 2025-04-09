package src.merge.two.sorted.linkedlist;

import org.w3c.dom.Node;

public class LinkedList {
    Node head;

    public static class Node{
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

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        addElement(linkedList, 1);
        addElement(linkedList, 2);
        addElement(linkedList, 4);
        iterateLinkedList(linkedList);

        LinkedList linkedList2 = new LinkedList();
        addElement(linkedList2, 0);
        addElement(linkedList2, 3);
        addElement(linkedList2, 4);
        iterateLinkedList(linkedList);
        LinkedList linkedListResult = mergeLinkedLists(linkedList, linkedList2);
        System.out.println("final result");
        iterateLinkedList(linkedListResult);
    }

    private static LinkedList mergeLinkedLists(LinkedList linkedList1, LinkedList linkedList2){
        if(linkedList1.head==null && linkedList2.head==null){
            return linkedList1;
        }

        if(linkedList1.head==null && linkedList2.head!=null){
            return  linkedList2;
        }

        if(linkedList1.head!=null && linkedList2.head==null){
            return  linkedList1;
        }

        LinkedList linkedList = new LinkedList();
        linkedList.head = null;
        Node node = null;

        Node currentNode = linkedList1.head;
        Node currentNode2 = linkedList2.head;
        while(currentNode!=null && currentNode2!=null){
            if(currentNode.data<=currentNode2.data){
                Node tempNode = currentNode;
                currentNode = currentNode.next;
                if(linkedList.head==null){
                    linkedList.head = tempNode;
                    node = linkedList.head;
                } else {
                    node.next = tempNode;
                    node = node.next;
                }
                //System.out.println("node "+node.data);
            } else {
                Node tempNode = currentNode2;
                currentNode2 = currentNode2.next;
                if(linkedList.head==null){
                    linkedList.head = tempNode;
                    node = linkedList.head;
                } else {
                    node.next = tempNode;
                    node = node.next;
                }
                //System.out.println("node 2 "+node.data);
            }
        }

       if(currentNode2 == null && currentNode!=null){
            node.next = currentNode;
        }

        if(currentNode==null && currentNode2!=null){
            node.next = currentNode2;
        }

        return linkedList;
    }
}
