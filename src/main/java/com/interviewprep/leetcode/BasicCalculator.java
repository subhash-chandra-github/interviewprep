package com.interviewprep.leetcode;

import java.util.Stack;

public class BasicCalculator {


    public static void main(String[] args) {
        String s = "1-(     -2)";

        int ans = calculate(s);
        System.out.println(ans);
    }

    public static int calculate(String s) {

        int operand = 0;
        int n = 0;
        Stack<Object> stack = new Stack<>();

        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                while(Character.isDigit(s.charAt(i))){
                    ch = s.charAt(i);
                    operand = (int) Math.pow(10,n)* (ch-'0')+  operand;
                    n++;
                    if(i>0 && Character.isDigit(s.charAt(i-1))) {
                        i--;
                    }else{
                        break;
                    }
                }
                stack.push(operand);
                n=0;
                operand = 0;
            }
            else if(ch!= ' '){
                if(ch=='('){
                    if (stack.empty() || !(stack.peek() instanceof Integer)) {
                        stack.push(0);
                    }
                    int res = (int)stack.pop();
                    while(!stack.empty() && !((char) stack.peek() == ')') ){
                        char sign = (char) stack.pop();
                        if (sign == '+') {
                            res += (int) stack.pop();
                        } else {
                            res -= (int) stack.pop();
                        }
                    }
                    stack.pop();
                    stack.push(res);
                }else{
                    stack.push(ch);
                }
            }
        }
        if (stack.empty() || !(stack.peek() instanceof Integer)) {
            stack.push(0);
        }
        int res = (int)stack.pop();
        // Evaluate the expression till we get corresponding ')'
        while (!stack.empty() && !((char) stack.peek() == ')')) {

            char sign = (char) stack.pop();

            if (sign == '+') {
                res += (int) stack.pop();
            } else {
                res -= (int) stack.pop();
            }
        }
        return res;
    }
}
