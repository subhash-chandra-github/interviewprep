package com.interviewprep.leetcode;

import java.util.*;

public class GroupAnagram {

    public static void main(String[] args) {

       String[] strs = new String[]{"eat","tea","tan","ate","nat","bat"};
        List<List<String>> ans = groupAnagrams(strs);
        System.out.println(ans);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {


        Map<String,List<String>> mp = new HashMap<>();
        for(int i=0;i<strs.length;i++)
        {
            char tempArray[] = strs[i].toCharArray();
            Arrays.sort(tempArray);
            String s = new String(tempArray);
            if(mp.containsKey(s)){
                mp.get(s).add(strs[i]);
            }else{
                List<String> lst = new ArrayList<>();
                lst.add(strs[i]);
                mp.put(s,lst);
            }

        }
        List<List<String>> ans = new ArrayList<>();
        mp.forEach((key,value)->{
            ans.add(value);
        });
        return ans;


    }
}
