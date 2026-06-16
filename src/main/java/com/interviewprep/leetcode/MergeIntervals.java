package com.interviewprep.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public static void main(String[] args) {

        int[][] intervals = new int[][]{{1,3},{2,6},{8,10},{15,18}};
       // int[][] intervals = new int[][]{{1,4},{4,5}};
        int[][] ans = merge(intervals);
        for(int[] i : ans){
            System.out.println(Arrays.toString(i));
        }

    }
    public static int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0][];
        }

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> m = new ArrayList<>();
        int pStart = intervals[0][0];
        int pEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            int cStart = intervals[i][0];
            int cEnd = intervals[i][1];

            if (pEnd >= cStart) {
                pEnd = Math.max(pEnd, cEnd);
            } else {
                m.add(new int[]{pStart, pEnd});
                pStart = cStart;
                pEnd = cEnd;
            }
        }
        m.add(new int[]{pStart, pEnd}); // flush the last interval

        return m.toArray(new int[m.size()][]);
    }
}
