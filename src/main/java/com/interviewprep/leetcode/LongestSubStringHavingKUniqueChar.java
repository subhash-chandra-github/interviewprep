package com.interviewprep.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringHavingKUniqueChar {

    public static void main(String[] args) {
        String str = "aabacbebebe";
        int k = 3;

        System.out.println(longestkSubstr(str,k));

    }

    public static int longestkSubstr(String s, int k) {
        // code here
        Map<Character,Integer> mp = new HashMap<>();
        int i=0;
        int maxLen = 0;
        boolean ans= false;
        for(int j=0;j<s.length();j++){
            char c = s.charAt(j);
            mp.put(c,mp.getOrDefault(c,0)+1);
            if(mp.size()>=k){
                ans = true;
            }
            while(mp.size()>k){
                char lchar = s.charAt(i);
                mp.put(lchar, mp.get(lchar)-1);
                if(mp.get(lchar)==0){
                    mp.remove(lchar);
                }
                i++;

            }
            maxLen = Math.max(maxLen, j-i+1);
        }
        if(ans){
            return maxLen;
        }
        return -1;
    }
}
