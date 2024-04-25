package com.interviewprep.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Substring_with_Concatenation_of_All_Words {


    public static void main(String[] args) {

        String s = "barfoothefoobarman";
        String[] words = new String[]{"foo","bar"};

        System.out.println(findSubstring(s,words));

    }


    public static List<Integer> findSubstring(String s, String[] words) {

        List<Integer> ans = new ArrayList<>();
        Set<String> wordSet = new HashSet<>();
        for(String w : words){
            wordSet.add(w);
        }
        String temp = "";
        int l = words[0].length();
        int fl = l*words.length;
        int vl=0;
        int si=0;
        for(int i=0;i<s.length();i++){
            if(temp.length()<l){
                temp = temp+s.charAt(i);
                continue;
            }
            else if(temp.length()==l){
                if(wordSet.contains(temp)){
                    vl = vl+l;
                }else{
                    si = i;
                }
                temp = ""+s.charAt(i);
            }
            if(vl==fl && (i-si)==fl){
                ans.add(si);
                vl=0;
            }
        }
        return ans;
    }
}
