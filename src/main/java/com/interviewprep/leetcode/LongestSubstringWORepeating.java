package com.interviewprep.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWORepeating {

    public static int lengthOfLongestSubstring(String s) {
        int j=0;
        int i=0;
        int n = s.length();
        int maxlen = 0;
        Set<Character> set = new HashSet<>();
        while(j<n){
            char a = s.charAt(j);
            if(!set.contains(a)){
                set.add(a);
                maxlen = Math.max(maxlen,j-i+1);
                j++;
            }else{
                set.remove(s.charAt(i));
                i++;

            }
// p w w k e w  i=0    abcadgrfj = > bcadgrfj
// 0 1 2 3 4 5  j=2

        }
        return maxlen;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("aaabcadgrfj"));
    }
}

