package com.interviewprep.dsa.linkedList;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Node {

     int value;
     Node next;

   public Node(int value){

       this.value = value;
       this.next = null;
    }


    public static void main(String[] args) {
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>(){
            @Override
            public int compare(Node k1, Node k2)
            {
                if (k1.value > k2.value)
                    return 1;
                else if (k1.value < k2.value)
                    return -1;
                return 0;
            }

        });
    }
}
