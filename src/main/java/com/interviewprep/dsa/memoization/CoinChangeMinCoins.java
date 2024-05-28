package com.interviewprep.dsa.memoization;

import java.util.Arrays;

public class CoinChangeMinCoins {

    public static void main(String[] args) {

        int[] coins = new int[]{1,3,5,7};
        int amt = 18;
        int dp[] = new int[amt];
        Arrays.fill(dp,-1);
        dp[0]=0;
        System.out.println(minCoin(coins,amt,coins.length,dp));

    }

    public static int minCoin(int[] coins, int amt, int n, int dp[]){

        if(amt==0){
            return 0;
        }
        if(dp[amt]!=-1){
            return dp[amt];
        }
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(coins[i]<=amt){
                int currCoin = minCoin(coins, amt - coins[i], n, dp);
                if(currCoin!=Integer.MAX_VALUE && currCoin+1 < ans){
                    ans = currCoin+1;
                }
            }
        }
        return dp[amt]=ans;

    }
}
