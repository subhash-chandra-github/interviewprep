package com.interviewprep.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by subhash on 7/2/21.
 */
public class MissingNo {

    public static void main(String args[]) {

        int ans = thirdMax();
        System.out.println(ans);
    }

    public static int thirdMax() {
        int[] nums = new int[]{3,2,1};
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        for (Integer a : set) {
            if (a > max1) {
                max3 = max2;
                max2 = max1;
                max1 = a;

            }
            else if (a > max2) {
                max3 = max2;
                max2 = a;
            }
            else if (a >= max3) {
                max3 = a;
            }
        }
        if(set.size()>3)
            return max3;
        else
            return max1;

    }
}
