package com.interviewprep.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Find_All_Duplicates_in_Array {

    public static void main(String[] args) {

        int[] a = new int[]{4,3,2,7,8,2,3,1};
        findDuplicates(a);
    }

    public static List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            nums[Math.abs((Math.abs(nums[i])-1))] = nums[Math.abs((Math.abs(nums[i])-1))]*-1;
        }
        for(int i=0;i<n;i++){
            System.out.print(" "+nums[i]);
        }
        return ans;
    }
}
