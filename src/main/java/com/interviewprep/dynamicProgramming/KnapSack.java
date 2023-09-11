package com.interviewprep.dynamicProgramming;

public class KnapSack {


    private static int calculate(int[] wt, int[] v, int W, int n){

            int[] dp = new int[W+1];

//            for(int i=1;i<=n;i++){
//                for(int j=W;j>=0;j--){
//
//                    if(wt[i-1]<=j){
//                        dp[j] = Math.max(dp[j], dp[j-wt[i-1]]+v[i-1]);
//                    }
//
//                }
//
//            }

        for(int i=1;i<=n;i++){
            for(int j=0;j<=W;j++){

                if(wt[i-1]<=j){
                    dp[j] = Math.max(dp[j], dp[j-wt[i-1]]+v[i-1]);
                }

            }

        }

            return dp[W];


    }


    public static void main(String[] args) {

        int val[] = { 60, 100, 120 };
        int wt[] = { 10, 20, 30 };
        int W = 50;
        int n = val.length;
        System.out.print(calculate(wt, val,W, n));
    }
}
