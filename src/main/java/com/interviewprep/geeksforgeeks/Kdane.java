package com.interviewprep.geeksforgeeks;

import java.util.HashMap;
import java.util.Map;

public class Kdane {
    public static void main(String[] args) {
        int[] a = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println("Maximum contiguous sum is " +
                maxSubArraySum(a));
        Map<Integer,Integer> map = new HashMap<>();
        map.put(1,2);
        map.put(2,6);
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            System.out.println(entry.getKey());
        }
    }

    static int maxSubArraySum(int a[]) {
        int size = a.length;

        int curMax = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            curMax = curMax + a[i];
            if (max < curMax)
                max = curMax;
            if (curMax < 0)
                curMax = 0;
        }

        return max;

    }
} 