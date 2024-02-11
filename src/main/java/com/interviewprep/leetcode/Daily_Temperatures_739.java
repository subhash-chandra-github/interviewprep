package com.interviewprep.leetcode;

import java.util.Stack;

public class Daily_Temperatures_739 {


//    Input: temperatures = [73,74,75,71,69,72,76,73]
//    Output:               [1, 1, 4, 2,  1, 1, 0, 0]

    public static void main(String[] args) {
        int [] temp = new int[]{89,62,70,58,47,47,46,76,100,70};
        int[] out = dailyTemperatures(temp);
        System.out.println(out.toString());

    }
    public static int[] dailyTemperatures(int[] temperatures) {   //73  //76
        Stack<Integer> st = new Stack<>();
        int n = temperatures.length;
        int ans[] = new int[n];
        st.push(n-1);
        ans[n-1] = 0;
        for(int i=n-2;i>=0;i--){
            if(temperatures[st.peek()]<=temperatures[i]){
                while(!st.isEmpty() && temperatures[st.peek()]<=temperatures[i]){
                    st.pop();
                }
                if(st.isEmpty()){
                    ans[i]=0;
                }else{
                    ans[i] = st.peek()-i;
                }
                st.push(i);
            }else{
                ans[i] = st.peek()-i;
                st.push(i);

            }
        }
        return ans;

    }
}
