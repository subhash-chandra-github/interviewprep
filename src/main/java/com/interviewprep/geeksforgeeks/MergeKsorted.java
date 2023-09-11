package com.interviewprep.geeksforgeeks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKsorted {


    private List<Integer> mergeKsorted(List<List<Integer>> lists){

        List<Integer> ans = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (List<Integer> integers : lists) {
            pq.add(integers.get(0));
        }

        int j=1;
        while(!pq.isEmpty()){

            ans.add(pq.poll());
            for (List<Integer> list : lists) {
                if (j < list.size()) {
                    pq.add(list.get(j));
                }

            }
            j++;
        }
   return ans;


    }


    public static void main(String[] args) {

        MergeKsorted ksorted = new MergeKsorted();

        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> l1 = Arrays.asList(0,3,6,9,11);
        List<Integer> l2 = Arrays.asList(1,5,7,13);
        List<Integer> l3 = Arrays.asList(2,4,8,10);

        lists.add(l1);
        lists.add(l2);
        lists.add(l3);

        List<Integer> ans = ksorted.mergeKsorted(lists);

        System.out.println(ans);
    }
}
