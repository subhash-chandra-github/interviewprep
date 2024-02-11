package com.interviewprep.leetcode;

import java.util.Arrays;

public class Remove_Duplicates_from_Sorted_Array_II {

    public static void main(String[] args) {

        int[] a = new int[]{0,0,1,1,1,1,2,3,3};
        System.out.println(removeDuplicates(a));
        for(int i=0;i<a.length;i++) {
            System.out.print(a[i]+" ");
        }
    }

    public static int removeDuplicates(int[] nums) {

        int i=1;
        int j=1;
        int count=1;
        while(i<nums.length){
            if(nums[i-1]==nums[i]){
                count++;
            }else{
                count=1;
            }
            if(count<=2){
            nums[j++] = nums[i];
            }
            i++;
        }
        return j;
    }
}
