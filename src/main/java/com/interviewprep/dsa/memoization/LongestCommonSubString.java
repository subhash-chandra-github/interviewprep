package com.interviewprep.dsa.memoization;

public class LongestCommonSubString {

    public static void main(String[] args) {

        String x = "abcfghik";
        String y = "abcflhik";  //6
        int m = x.length();
        int n = y.length();

        int ans = lis(x,y,m,n,0);

        System.out.println("Longest Increasing SubString length = "+ans);

    }

    public static int lis(String x, String y, int m, int n, int count){

        if(m==0 || n==0){
            return count;
        }
        if(x.charAt(m-1)==y.charAt(n-1)){
            count = lis(x,y,m-1,n-1,count+1);
        }else {
            count = Math.max(count,
            Math.max(lis(x,y,m,n-1,0),
                    lis(x,y,m-1,n,0)));
        }

        return count;

    }
}
