package com.interviewprep.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DecodeString {


    public static void main(String[] args) {

        String d  = "3[z]2[2[y]pq4[2[jk]e1[f]]]ef";
        String expandedString = decodeString(d);
        System.out.println(expandedString);

    }

    private static String decodeString(String s){

        Stack<Character> st = new Stack<>();
        char[] c = s.toCharArray();
        StringBuilder sb = new StringBuilder("");
        int i =0;

        while(i<c.length){
            if(c[i]==']'){
                String res = "";
                if(!st.isEmpty()){
                    StringBuilder temp = new StringBuilder();
                    while(!st.isEmpty() && st.peek()!='['){
                         temp.append(st.pop());
                    }
                    st.pop();
                    int f = 0;
                    int b =1;
                    while(!st.isEmpty()&&Character.isDigit(st.peek())){
                        f = f+(st.pop()-'0')*b;
                        b= b*10;
                    }
                    List<String> lst = new ArrayList<>();
                   for(int j=1;j<=f;j++){
                       lst.add(temp.toString());
                   }
                   res = String.join("", lst);
                }
                if(res.length()>=1){
                    for(int j = res.length()-1;j>=0;j--){
                        st.push(res.charAt(j));
                    }
                }
            }else{
                st.push(c[i]);
            }
            i++;

        }
        while(!st.isEmpty()){
            sb.append(st.pop());

        }
        return sb.reverse().toString();


    }
}
//3[z]2[2[y]pq4[2[jk]e1[f]]]ef
//zzz2[yypq4[jkjkef]]ef
//zzz2[yypqjkjkefjkjkefjkjkefjkjkef]ef
//zzz yypqjkjkefjkjkefjkjkefjkjkef yypqjkjkefjkjkefjkjkefjkjkefef
//zzz yypqjkjkefjkjkefjkjkefjkjkef yypqjkjkefjkjkefjkjkefjkjkefef
//zzz yypqjkjkefjkjkefjkjkefjkjkef yypqjkjkefjkjkefjkjkefjkjkefef