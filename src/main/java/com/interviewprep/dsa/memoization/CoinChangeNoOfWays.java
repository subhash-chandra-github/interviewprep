package com.interviewprep.dsa.memoization;

import java.util.Arrays;

public class CoinChangeNoOfWays {

    public static void main(String[] args) {

        int[] coins = new int[]{1,2,3};
        int amt = 5;
        int n = coins.length;
        int[][] dp = new int[n+1][amt+1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        System.out.println(noOfWays(coins,amt,coins.length,dp));

    }

    public static int noOfWays(int[] coins, int amt, int n, int[][] dp){

        if(amt==0){
            return dp[n][amt]=1;
        }
        if(amt<0){
            return 0;
        }
        if(n<=0){
            return 0;
        }
        if (dp[n][amt] != -1) {
            return dp[n][amt];
        }
        return dp[n][amt] = noOfWays(coins,amt,n-1,dp)
                +noOfWays(coins,amt-coins[n-1],n,dp);


    }
}
