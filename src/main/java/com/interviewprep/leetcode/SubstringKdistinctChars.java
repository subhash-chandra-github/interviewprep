package com.interviewprep.leetcode;

import java.util.HashMap;
import java.util.Map;

public class SubstringKdistinctChars {


    public static void main(String[] args) {

        String str = "aba";
        int k = 2;
        int ans = substringCountWithKdistinctChar(str,k)
                -substringCountWithKdistinctChar(str,k-1);

        System.out.println(ans);
    }

    private static int substringCountWithKdistinctChar(String str, int k) {

        int count = 0;
        int[] freq = new int[26];
        int distinct = 0;
        int i = 0;
        for(int j=0;j<str.length();j++){
            char ch = str.charAt(j);
            freq[ch-'a']++;
            if(freq[ch-'a']==1){
                distinct++;
            }
            while (distinct > k){
                char left = str.charAt(i);
                freq[left-'a']--;
                if(freq[left-'a']==0){
                    distinct--;
                }
                i++;
            }
            count = count + j-i+1;
        }

        return count;
    }

}
