package com.interviewprep.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKElements {

    public static void main(String[] args) {

        int[] array = new int[]{1,1,1,2,2,3};
        int k = 2;
        int[] ans = topKFrequent(array,k);
        System.out.println();
        for(int e : ans){
            System.out.print(e+ " ");
        }

    }

    public static int[] topKFrequent(int[] nums, int k) {
        List<Integer>[] buckets = new List[nums.length + 1];
        Map<Integer, Integer> mp = new HashMap<>();

        for (int num : nums) {
            int f = mp.getOrDefault(num, 0) + 1;
            mp.put(num, f);
        }

        mp.forEach((key,value)->{
            System.out.println("key: "+key+" value: "+value);
        });

        for(int key : mp.keySet()){
            int f = mp.get(key);
            if(buckets[f]==null){
                buckets[f]= new ArrayList<>();
            }
            buckets[f].add(key);
        }
        List<Integer> res = new ArrayList<>();

        for(int pos = buckets.length-1; pos>=0 && res.size()<k; pos--){
            if(buckets[pos]!=null){
                res.addAll(buckets[pos]);
            }
        }
        return res.stream().mapToInt(i->i).toArray();

    }
}
