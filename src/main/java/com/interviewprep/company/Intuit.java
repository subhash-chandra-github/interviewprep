package com.interviewprep.company;

import java.util.ArrayList;
import java.util.List;

public class Intuit {

    //Given two linked lists, insert nodes of second list into first list at alternate positions of first list.
//For example, if first list is 5->7->17->13->11 and second is 12->10->2->4->6, the first list should become
//5->12->7->10->17->2->13->4->11->6 and second list should become empty. The nodes of second list should only
//be inserted when there are positions available. For example, if the first list is 1->2->3 and second list is 4->5->6->7->8, then first list should become 1->4->2->5->3->6 and second list to 7->8.

//Use of extra space is not allowed (Not allowed to create additional nodes), i.e., insertion must be done in-place. Expected time complexity is O(n) where n is number of nodes in first list.

    class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }

        Node() {
            this.data = 0;
            this.next = null;
        }


    }

    public static void main(String[] args) {


        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(7);
        list.add(17);
        list.add(11);
        list.add(13);

        Intuit sc = new Intuit();
        Node head1 = sc.createLinkedList(list);
        //   printList(head1);

        List<Integer> list2 = new ArrayList<>();
        list2.add(12);
        list2.add(10);
        list2.add(2);
        list2.add(4);
        list2.add(6);
        Node head2 = sc.createLinkedList(list2);
        //  printList(head2);


        head1 = sc.merge(head1, head2);

        printList(head1);
    }

    public Node merge(Node head1, Node head2) {    //5-7-17-11-13   //12-10-2-4-6   temp = 7,9

        Node current1 = head1;
        Node current2 = head2;
//        Node next1;
//        Node next2;
//        while (current1 != null && current2 != null) {
//            next1 = current1.next;
//            next2 = current2.next;
//
//            current2.next = next1;
//            current1.next = current2;
//
//            current1 = next1;
//            current2 = next2;
//        }
//        head2 = current2;

        int s = getSize(head1);
                      //  c1            c2      t
        while(s>0){   //6->7-8->10    7->9      8->10   //5-7-17-11-13   //12-10-2-4-6

            Node temp = current1.next;
            current1.next = new Node(current2.data);
            current1 = current1.next;
            current1.next=temp;
            s--;

            current1 = temp;
            current2 = current2.next;

        }



        return head1;
    }


    public Node createLinkedList(List<Integer> datas) {

        Node head = null;
        Node current = null;
        if (datas.isEmpty()) {
            return null;
        }
        head = new Node(datas.get(0));
        current = head;
        for (int i = 1; i < datas.size(); i++) {
            int d = datas.get(i);
            Node temp = new Node(d);
            current.next = temp;
            current = current.next;


        }
        return head;

    }

    public static void printList(Node head) {

        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public static int getSize(Node head) {
        int c = 0;
        while (head != null) {
            c++;
            head = head.next;
        }
        return c;
    }


}

