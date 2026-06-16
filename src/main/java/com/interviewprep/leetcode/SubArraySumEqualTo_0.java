package com.interviewprep.leetcode;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualTo_0 {

    public static void main(String[] args) {
        int[] arr = {9, -3, 3, -1, 6, -5};
        int target = 0;
        int maxLen = maxLen(arr, target);
        System.out.println("Maxlen :"+maxLen);
    }

    private static int maxLen(int[] arr, int target) {
        Map<Integer, Integer> mp = new HashMap<>();

        int curSum = 0;
        int maxLen = 0;

        for (int i = 0; i < arr.length; i++) {
            curSum = curSum + arr[i];
            if (mp.containsKey(curSum)) {
                maxLen = Math.max(maxLen, i - mp.get(curSum));
            } else {
                mp.put(curSum, i);
            }
        }
        return maxLen;
    }
}
