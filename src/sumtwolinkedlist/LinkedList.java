package src.sumtwolinkedlist;

public class LinkedList {
    Node head;
    public static class Node{
        int val;
        Node next;
        Node(int data){
            this.val = data;
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
            System.out.println(currentNode.val);
            currentNode = currentNode.next;
        }
    }
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        addElement(linkedList, 9);
        addElement(linkedList, 9);
        addElement(linkedList, 9);
        addElement(linkedList, 9);
        addElement(linkedList, 9);
        addElement(linkedList, 9);

        System.out.println("linkedlist 1");
        iterateLinkedList(linkedList);
        LinkedList linkedList2 = new LinkedList();
        addElement(linkedList2, 9);
        addElement(linkedList2, 9);
        addElement(linkedList2, 9);
        System.out.println("linked list 2");
        iterateLinkedList(linkedList2);
        sumLinkedlists(linkedList, linkedList2);
    }

    private static void sumLinkedlists(LinkedList linkedList, LinkedList linkedList2) {
        Node currentNode1 = linkedList.head;
        Node currentNode2 = linkedList2.head;
        Node previousPointer = linkedList.head;
        int carry = 0;
        while(currentNode1!=null && currentNode2!=null){
            int sum = currentNode1.val + currentNode2.val+carry;
            if(sum>=10){
                carry = 1;
                int reminder = sum%10;
                currentNode1.val = reminder;
            } else {
                carry = 0;
                currentNode1.val = sum;
            }
            previousPointer = currentNode1;
            currentNode1 = currentNode1.next;
            currentNode2 = currentNode2.next;
        }
        if(currentNode1==null && currentNode2!=null){
            Node head = currentNode2;
            while(currentNode2!=null){
                int sum = currentNode2.val+carry;
                if(sum>=10){
                    carry = 1;
                    currentNode2.val = sum%10;
                } else {
                    carry = 0;
                    currentNode2.val = sum%10;
                }
                currentNode2 = currentNode2.next;
            }
            previousPointer.next = head;
        }

        if(currentNode1!=null && currentNode2==null){
            while(currentNode1!=null){
                int sum = currentNode1.val+carry;
                if(sum>=10){
                    carry = 1;
                    currentNode1.val = sum%10;
                } else {
                    carry = 0;
                    currentNode1.val = sum%10;
                }
                previousPointer = currentNode1;
                currentNode1 = currentNode1.next;
            }
        }
        if(carry==1){
            Node node = new Node(1);
            if(currentNode1==null && currentNode2==null){
                previousPointer.next = node;
            } else {
                currentNode1.next = node;
            }
        }
        System.out.println("iterate after sum : ");
        iterateLinkedList(linkedList);
    }
}
