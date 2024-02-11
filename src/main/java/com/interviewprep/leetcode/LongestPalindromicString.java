package com.interviewprep.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LongestPalindromicString {

    public static void main(String[] args) {

        System.out.println(getLongestPalindromes("babad"));

    }
        public static String getLongestPalindromes(String testString) {

            String s = testString.toLowerCase();
            int n = testString.length();
            int start = 0;
            int maxLength = 1;
            List<String> result = new ArrayList<>();
            for(int i=0;i<n;i++){
                int low = i-1;
                int high = i+1;
                while(low>=0 && (s.charAt(low)==s.charAt(i))){
                    low--;
                }
                while(high<n && (s.charAt(high)==s.charAt(i))){
                    high++;
                }
                while(high<n && low>=0 && (s.charAt(high)==s.charAt(low))){
                    high++;
                    low--;
                }
                if(maxLength < high-low-1){
                    maxLength = high-low-1;
                    start = low+1;
                }
            }
            return testString.substring(start, start+maxLength);

        }

    }

