package com.interviewprep.leetcode;

public class JumpGame3 {

    public static void main(String[] args) {
        int[] arr = new int[]{3,0,2,1,2};
        System.out.println(canReach(arr,2));
    }

    public static boolean canReach(int[] arr, int start) {
        if(start<0 || start>=arr.length){
            return false;
        }
        if(arr[start]==0){
            return true;
        }
        return canReach(arr,start+arr[start]) || canReach(arr,start-arr[start]);
    }
}
