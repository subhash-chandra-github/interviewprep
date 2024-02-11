package com.interviewprep.leetcode;

import java.util.*;

public class PolishNotation {

    int result(String[] tokens){
        Stack<Integer> st = new Stack<Integer>();
        Set<String> op = new HashSet<>(Arrays.asList("+","-","/","*"));
        for(String s : tokens){
            if(op.contains(s)){
                int a = st.pop();
                int b = st.pop();
                switch(s){
                    case "+":
                        st.push(a+b);
                        break;
                    case "-":
                        st.push(b-a);
                        break;
                    case "*":
                        st.push(a*b);
                        break;
                    case "/":
                        st.push(b/a);
                        break;
                }
            }else{
                st.push(Integer.parseInt(s));
            }
        }
        return st.pop();
    }
}
