package com.interviewprep.company;


import java.util.LinkedList;
import java.util.Queue;

//    Design a hit counter that counts the no.of hits in the last ‘x’ minutes from the given timestamp.
//◦ public void hit(int timestamp) Records a hit that happened at timestamp (in seconds). Multiple hits can happen at the same time. Hit method will be called with timestamp in ascending order only. For e.g. hit(3) can’t be called after hit(4)
//◦ public int getHits(int timestamp) Returns the number of hits in the past x minutes from timestamp. getHits method will only be called with timestamp in ascending order.
//◦ The value of ‘x’ should be configurable.
//            Sample:
//    X -> 1 minute
//    hit(1)
//    hit(1)
//    hit(10)
//    hit(59)
//    getHIts(1) -> 2
//    getHIts(60) -> 4
//    getHits(65) -> 2   //getHits(63)

//1 2 3 4 5 6 7 8 9 10

public class HitCounter {

    private int hitCountValidity;

    private Queue<Integer> hitEvents;

    public HitCounter(int hitCountValidityInMinutes){
        this.hitCountValidity = hitCountValidityInMinutes*60;
        hitEvents = new LinkedList<>();
    }

    private void hit(int timeStamp){
//        while( !hitEvents.isEmpty() && (timeStamp - hitEvents.peek() > hitCountValidity)){
//            hitEvents.poll();
//        }
        hitEvents.add(timeStamp);
    }

    private int getHits(int timeStamp){
        int hitCount = 0;
        while( !hitEvents.isEmpty() && (timeStamp - hitEvents.peek() > hitCountValidity)){
            hitEvents.poll();
        }
        for(Integer i : hitEvents){
            if(i<=timeStamp){
                hitCount++;
            }
        }
      //  hitCount = hitEvents.size();
        return hitCount;

    }

    public static void main(String[] args) {
        HitCounter hitCounter = new HitCounter(1);

        hitCounter.hit(1);
        hitCounter.hit(1);
        hitCounter.hit(10);
        hitCounter.hit(59);
        hitCounter.hit(60);
        hitCounter.hit(100);
        hitCounter.hit(200);
        hitCounter.hit(500);
        hitCounter.hit(800);
        hitCounter.hit(1000);
        System.out.println(hitCounter.getHits(1));
        System.out.println(hitCounter.getHits(60));
        System.out.println(hitCounter.getHits(65));
        System.out.println(hitCounter.getHits(100));
        System.out.println(hitCounter.getHits(1000));

    }




}
