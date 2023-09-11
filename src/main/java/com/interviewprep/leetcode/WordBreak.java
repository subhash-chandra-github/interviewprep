package com.interviewprep.leetcode;

import java.util.*;

public class WordBreak {

    public static void main(String[] args) {

        System.out.println(wordBreak("leetcode",Arrays.asList("leet","code")));

    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        Set<String> dict = new HashSet<>(wordDict);
        dp[0] = true;
        for(int i=1;i<=n;i++){
            for(int j=0;j<i;j++){

                String wb = s.substring(j,i);
                if(dict.contains(wb)&&dp[j]){
                    dp[i] = true;
                    break;
                }

            }
        }

        return dp[n];
    }
}
