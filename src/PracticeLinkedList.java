package src;

import java.util.LinkedList;
import java.util.List;

public class PracticeLinkedList {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.add("Geeks");
        linkedList.add(" for ");
        linkedList.add("Geeks");
        System.out.println(linkedList);
        linkedList.addFirst("The ");
        System.out.println(linkedList);
        linkedList.addLast(" community.");
        System.out.println(linkedList);
        linkedList.removeLast();
        System.out.println(linkedList);
        linkedList.remove(3);
        System.out.println(linkedList);
        linkedList.add(3, "Geeks");
        System.out.println(linkedList);
        linkedList.set(2, "Geeks");
        System.out.println(linkedList);
        iterateLinkedList(linkedList);
    }

    private static void iterateLinkedList(LinkedList<String> linkedList) {
        System.out.println("LinkedList Elements : ");
        for(int i=0;i<linkedList.size();i++) {
            System.out.println(linkedList.get(i));
        }
    }


}
