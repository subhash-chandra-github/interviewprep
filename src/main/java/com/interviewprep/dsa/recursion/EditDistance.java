package com.interviewprep.dsa.recursion;

import java.util.Comparator;
import java.util.PriorityQueue;

public class EditDistance {


    public static void main(String[] args) {
        String a = "Subhash";
        String b = "Shubham";

        System.out.println(editDistance(a,b,a.length(),b.length()));

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        });

    }

    public static int editDistance(String s1, String s2, int m, int n){

        if(m==0){
            return n;
        }
        if(n==0){
            return m;
        }

        if(s1.charAt(m-1)==s2.charAt(n-1)){
            return editDistance(s1,s2,m-1,n-1);
        }
        return 1 + Math.min(Math.min(editDistance(s1,s2,m-1,n-1),
                editDistance(s1,s2,m,n-1)),editDistance(s1,s2,m-1,n));
    }
}
