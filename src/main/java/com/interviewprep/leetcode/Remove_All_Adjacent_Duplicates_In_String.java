package com.interviewprep.leetcode;

import java.util.Stack;

public class Remove_All_Adjacent_Duplicates_In_String {

    public static void main(String[] args) {

        System.out.println(removeDuplicates("azxxzy"));
    }

    public static String removeDuplicates(String s) {
        Stack<Character> st = new Stack<>();
        for(int i=s.length()-1;i>=0;i--){
            st.push(s.charAt(i));
        }
        Character s1 = st.pop();
        StringBuilder temp = new StringBuilder(s1.toString());
        while(!st.isEmpty()){
            Character c = st.pop();
            if(temp.length() >0 && c==temp.charAt(temp.length()-1)){
                temp.deleteCharAt(temp.length()-1);
            }else{
                temp.append(c);
            }
        }
        return temp.toString();
    }

}
