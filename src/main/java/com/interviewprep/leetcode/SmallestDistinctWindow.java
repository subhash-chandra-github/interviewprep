package com.interviewprep.leetcode;

import java.util.Arrays;

public class SmallestDistinctWindow {

    static final int MAX_CHARS = 256;

    public static void main(String[] args) {

        System.out.println(findSubString("GEEKSGEEKSFOR"));

    }
    public static int findSubString( String str) {
        // Your code goes here
        boolean[] visited = new boolean[256];
        Arrays.fill(visited,false);
        char[] cs = str.toCharArray();
        int distCount = 0;
        for(int i=0;i<cs.length;i++){
            if(!visited[cs[i]]){
                visited[cs[i]] = true;
                distCount++;
            }
        }
        int[] freq = new int[256];
        int count = 0;
        int start = 0, start_index = -1;
        int min_len = Integer.MAX_VALUE;

        for(int i=0;i<cs.length;i++){

            freq[cs[i]]++;
            if(freq[cs[i]]==1){
                count++;
            }
            if(distCount == count){
                while(freq[cs[start]]>1){
                    if(freq[cs[start]]>1){
                        freq[cs[start]]--;
                    }
                    start++;
                }
                int len_window = i - start + 1;
                if (min_len > len_window) {
                    min_len = len_window;
                    start_index = start;
                }

            }
        }
         System.out.println("ans = "+str.substring(start_index,
                              start_index + min_len));
        return min_len;


    }
}
