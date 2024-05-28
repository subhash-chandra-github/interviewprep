package com.interviewprep.dsa.linkedList;

import java.util.Arrays;
import java.util.List;

public class ReverseLinkedList {


    public static void main(String[] args) {

        Node head = createLinkedList(Arrays.asList(1,2,3,4,5,6,7));
        Node curr = reverseLinkedRecur(head);
        while (curr!=null){
            System.out.print(curr.value+" ");
            curr = curr.next;
        }


    }

    public static Node reverseLinkedList(Node head){

        Node curr = head;
        Node prev = null;
        Node next = null;

        while (curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
                                                                     //  |
    public static Node reverseLinkedRecur(Node head){   // null<-1<-2--newNode;
        if(head.next==null){
            return head;
        }
        Node newNode = reverseLinkedRecur(head.next);
        head.next.next = head;
        head.next=null;
        return newNode;
    }

    public static Node createLinkedList(List<Integer> values) {

        Node head = null;
        Node current = null;
        if (values.isEmpty()) {
            return null;
        }
        head = new Node(values.get(0));
        current = head;
        for (int i = 1; i < values.size(); i++) {
            int d = values.get(i);
            Node temp = new Node(d);
            current.next = temp;
            current = current.next;
        }
        return head;

    }
}
