package com.interviewprep.coreJava;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class PQueue {


    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(
                new Comparator<Integer>(){
            @Override
            public int compare(Integer a,Integer b){
                if(b>a){
                    return 1;
                }
                if(b<a){
                    return -1;
                }
                return 0;
            }
        });

        pq.add(1);
        pq.add(2);
        pq.add(3);
        pq.add(9);
        pq.add(5);

        Iterator<Integer> itr = pq.iterator();

        while (!pq.isEmpty()){
            System.out.println(pq.poll());
        }

    }
}
