package com.interviewprep.dsa.memoization;

import java.util.Arrays;

public class LongestIncreasingSubSequence {

    public static void main(String[] args) {
        int arr[] = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        int arr2[] = new int[]{7,7,7,7,7,7,7};
        int ans = longestIncreasingSubSequence(arr2,arr2.length,0,-1);
        System.out.println(ans);
    }

    public static int longestIncreasingSubSequence(int[] arr, int n, int i, int prev){

        if(i==n){
            return 0;
        }
        int taken = 0;
        if(arr[i]>prev){
            taken = 1+longestIncreasingSubSequence(arr,n,i+1,arr[i]);
        }
        int notTaken = longestIncreasingSubSequence(arr,n,i+1,prev);

        return Math.max(taken, notTaken);

    }

    public int lengthOfLIS(int[] nums) {
        int n =  nums.length;
        int dp[] = new int[n];
        Arrays.fill(dp,1);
        // int ans = 1;
        // for(int i=1;i<n;i++){
        //     for(int j=i-1;j>=0;j--){
        //         if(nums[j]<nums[i]){
        //           dp[i] = Math.max(dp[i], dp[j]+1);
        //           ans = Math.max(ans,dp[i]);
        //         }
        //     }
        // }
        // for(int i=0;i<n;i++){
        //     System.out.print(dp[i]+ " ");
        // }
        // return ans;


        int ans = 1;
        for(int i=1;i<n;i++){
            ans = Math.max(ans,lengthOfLisRecur(nums,n,i,dp));
        }
        return ans;
    }

    // 1 2 3 4 5 7
    public int lengthOfLisRecur(int[] nums, int n, int i, int dp[]) {

        if(i==0){
            return 1;
        }
        if(dp[i]!=1){
            return dp[i];
        }
        int ans = 1;
        for(int j=i-1;j>=0;j--){
            if(nums[j]<nums[i]){
                ans = Math.max(ans, 1+lengthOfLisRecur(nums,n,j,dp));
            }
        }
        return dp[i] = ans;
    }
}
