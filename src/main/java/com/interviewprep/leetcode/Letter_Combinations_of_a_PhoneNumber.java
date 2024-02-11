package com.interviewprep.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Letter_Combinations_of_a_PhoneNumber {

    private Map<Character,String> keys;

    public Letter_Combinations_of_a_PhoneNumber() {
        keys = new HashMap<>();
        keys.put('2',"abc");
        keys.put('3',"def");
        keys.put('4',"ghi");
        keys.put('5',"jkl");
        keys.put('6',"mno");
        keys.put('7',"pqrs");
        keys.put('8',"tuv");
        keys.put('9',"wxyz");
    }

    public static void main(String[] args) {
        Letter_Combinations_of_a_PhoneNumber obj = new Letter_Combinations_of_a_PhoneNumber();
        List<String> ans = obj.letterCombinations("23");
        System.out.println(ans);
    }
    public  List<String> letterCombinations(String digits){
        List<String> ans = new ArrayList<>();
        letterCombinationsHelper(digits,ans,"",0);
        return ans;
    }

    private  void letterCombinationsHelper(String digits, List<String> ans, String res, int idx ) {

        if(idx==digits.length()){
            ans.add(res);
            return;
        }
        String s = keys.get(digits.charAt(idx));
        for(int i=0;i<s.length();i++){
            res = res+s.charAt(i);
            letterCombinationsHelper(digits,ans,res,idx+1);
            res=res.substring(0,res.length()-1);
        }
    }
}
