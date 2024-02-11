package com.interviewprep.leetcode;



public class LongestPalindromicStringDP {
    public static void main(String[] args) {

        System.out.println(getLongestPalindromes("cbbbczx"));

    }
    public static String getLongestPalindromes(String s) {

        int n = s.length();
        int start = 0;
        int maxLength = 1;
        int end = 0;
        boolean dp[][] = new boolean[n][n];
        for(int i=0;i<n;i++){
            dp[i][i]=true;
            for(int j=0;j<i;j++){
                if(s.charAt(i)==s.charAt(j) && (dp[j+1][i-1] || i-j<=2)){
                    dp[j][i] = true;
                    if (i - j + 1 > maxLength) {
                        maxLength = i - j + 1;
                        start = j;
                        end = i;
                    }
                }

            }
        }
        return s.substring(start,end+1);

    }
}
