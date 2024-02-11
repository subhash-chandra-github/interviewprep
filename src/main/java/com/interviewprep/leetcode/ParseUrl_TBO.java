package com.interviewprep.leetcode;

import java.util.HashSet;
import java.util.Set;

public class ParseUrl_TBO {

    public static void main(String[] args) {

        String result = solve("print://axxy/pp.pdf/");
        System.out.println(result);
    }
    public static String solve(String S){
        // Write your code here
        String result = "";
        String temp = "";
        Set<Character> cSet = new HashSet<>();
        cSet.add(':');
        cSet.add('/');
        int i=0;
        boolean b = false;
        boolean bracket = false;
        while(i<S.length()){
            if(cSet.contains(S.charAt(i))){
                i++;
                if(b){
                    b=false;
                    result = result+" "+temp;
                    temp = "";
                }
            }
            else {
                b=true;
                if(S.charAt(i)=='='){
                    temp = "["+temp+":";
                    result = result+" "+temp;
                    temp = "";
                    bracket=true;
                }
                else if(S.charAt(i)=='&'){
                    temp = temp+"]";
                    result = result+" "+temp;
                    temp = "";
                    bracket = true;
                }
                else if(S.charAt(i)!=':'||S.charAt(i)!='/') {
                    temp=temp+S.charAt(i);
                }
                i++;
            }

        }
        result = result+" "+temp;
        if(bracket){
            result=result+"]";
        }
        return result;

    }
}



