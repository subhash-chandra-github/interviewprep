package com.interviewprep.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MinHall {

    class Pair{
        int s;
        int e;
        Pair(int s, int e){
            this.s = s;
            this.e = e;
        }
    }


    public static void main(String[] args) {

        int[] s = new int[]{1,1,1,2,4,4};
        int[] e = new int[]{2,3,3,3,5,5};

        MinHall h = new MinHall();
        System.out.println(h.mingHalls(s,e));

    }

    private  int mingHalls(int[] s, int[] e){
        List<Pair> pairs = new ArrayList<>();
        for(int i=0;i<s.length;i++){
            pairs.add(new Pair(s[i],1));
            pairs.add(new Pair(e[i],-1));
        }

        pairs.sort(Comparator.comparingInt(p -> p.s));

        int answer = 0, sum = 0;

        for (int i = 0; i < pairs.size(); i++) {
            sum += pairs.get(i).e;
            answer = Math.max(answer, sum);
        }

        return answer;
    }




}
