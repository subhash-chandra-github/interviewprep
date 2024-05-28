package com.interviewprep.dsa.recursion;

public class CoinChangeMinCoin {
    public static void main(String[] args) {

        int[] coins = new int[]{1,3,5,7};
        int amt = 18;

        System.out.println(minCoin(coins,amt,coins.length));

    }

    public static int minCoin(int[] coins, int amt, int n){

        if(amt==0){
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(coins[i]<=amt){
                int currCoin = minCoin(coins,amt-coins[i],n);
                if(currCoin!=Integer.MAX_VALUE && currCoin+1 < ans){
                    ans = currCoin+1;
                }
            }
        }
        return ans;

    }
}
