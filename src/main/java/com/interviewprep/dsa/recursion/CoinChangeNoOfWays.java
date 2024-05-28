package com.interviewprep.dsa.recursion;

public class CoinChangeNoOfWays {

    public static void main(String[] args) {

        int[] coins = new int[]{1,2,3};
        int amt = 5;

        System.out.println(noOfWays(coins,amt,coins.length));

    }

    public static int noOfWays(int[] coins, int amt, int n){
//If the target sum (sum) is 0, there is only one way to make the
// sum, which is by not selecting any coin
        if(amt==0){
            return 1;
        }
        if(amt<0){
            return 0;
        }
        if(n<=0){
            return 0;
        }
        return noOfWays(coins,amt,n-1)
                +noOfWays(coins,amt-coins[n-1],n);


    }
}
