package com.interviewprep.leetcode;

public class JumpGame2 {
    public static void main(String[] args) {
        int[] arr = new int[]{2,3,1,1,4};
        System.out.println(jump(arr));
    }

    public static int jump(int[] nums) {
        int reachable=0;
        int lastJumpPosition = 0;
        int n = nums.length;
        int jumps = 0;
        for(int i=0;i<n-1;i++){

            reachable = Math.max(reachable,nums[i]+i);
            if(i==lastJumpPosition){
                jumps++;
                lastJumpPosition = reachable;
            }
        }
    return jumps;
    }
}
