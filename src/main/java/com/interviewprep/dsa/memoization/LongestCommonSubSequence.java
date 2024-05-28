package com.interviewprep.dsa.memoization;

public class LongestCommonSubSequence {

    public static void main(String[] args) {

        String x = "abcfghik";
        String y = "ahcflhik";  //6
        int m = x.length();
        int n = y.length();

        int ans = lis(x,y,m,n);

        System.out.println("Longest Increasing SubSequence length = "+ans);

    }

    public static int lis(String x, String y, int m, int n){

        if(m==0 || n==0){
            return 0;
        }
        if(x.charAt(m-1)==y.charAt(n-1)){
            return 1+lis(x,y,m-1,n-1);
        }else {
            return Math.max(lis(x,y,m-1,n),lis(x,y,m,n-1));
        }
    }
}
