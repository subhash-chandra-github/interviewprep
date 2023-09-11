package com.interviewprep.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinder {

    private PriorityQueue<Integer> p1;
    private PriorityQueue<Integer> p2;
    public MedianFinder() {
        this.p1 = new PriorityQueue<>(Comparator.reverseOrder());
        this.p2 = new PriorityQueue<>();
    }

    public void addNum(int num) {

        p1.add(num);
        p2.add(p1.poll());
        if(p2.size()>p1.size()){
            p1.add(p2.poll());
        }
    }

    public double findMedian() {

        if(p2.size()!=p1.size()){
            return p1.peek()*1.0;
        }
        return (p2.peek()*1.0 - p1.peek()*1.0)/2;

    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
    }
}
