package com.interviewprep.leetcode;

public class MajorityElement {

    //This algorithm works on the fact that if an element occurs more than N/2 times,
    // it means that the remaining
    // elements other than this would definitely be less than N/2

    public static void main(String[] args) {
        int[] a = new int[]{1,2,1,3,1,5,1};
        System.out.println(findCandidate(a));
    }

    public static int findCandidate(int[] nums) {

        int mj=0;
        int count = 1;
        for(int i=1;i<nums.length;i++){
            if(nums[mj]==nums[i]){
                count++;
            }else {
                count--;
            }
            if(count==0){
                mj=i;
                count=1;
            }
        }
        return nums[mj];
    }

    public static int majorityElement(int[] nums,int mj) {
        int count = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==mj){
                count++;
            }
        }
        if(count > nums.length/2){
            return mj;
        }else {
            return 0;

        }
    }
}
