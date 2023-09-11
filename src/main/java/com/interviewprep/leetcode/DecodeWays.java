package com.interviewprep.leetcode;

public class DecodeWays {


    public static void main(String[] args) {

     System.out.println(decodeWays("226",0));

    }

    private static int decodeWays(String s, int p){
        int n = s.length();
        if(p==n){
            return 1;
        }
        if(s.charAt(p)=='0'){
            return 0;
        }
        int res = decodeWays(s,p+1);
        if(p<n-1 && (s.charAt(p)=='1' || s.charAt(p)=='2') && s.charAt(p+1)<'7'){
            res = res + decodeWays(s,p+2);
        }
    return res;

    }



}
