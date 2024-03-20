package com.interviewprep.leetcode;

public class JumpGame {

    public static void main(String[] args) {

        int[] nums = new int[]{2,3,1,1,4};

        System.out.println(jump(nums));

    }

    private static boolean jump(int[] nums){

        int n = nums.length;
        int reachable = 0;
        for(int i=0;i<n;i++){
            if(i>reachable){
                return false;
            }
            reachable = Math.max(reachable,nums[i]+i);
            if(reachable==n){
                return true;
            }
        }
        return true;
    }
}
