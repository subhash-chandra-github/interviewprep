package com.interviewprep.leetcode;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementCircular {

    public static void main(String[] args) {
        NextGreaterElementCircular ngec = new NextGreaterElementCircular();
        int[] arr = {5, 7, 1, 2, 6};
        int[] ans = ngec.nextGreaterElements(arr);
        for (int x : ans) {
            System.out.print(x + " ");
        }
    }

    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);

        for(int i=2*n-1;i>=0;i--){
            int curr = nums[i % n];
            while (!st.isEmpty() && st.peek() <= curr) {
                st.pop();
            }

            if (i < n && !st.isEmpty()) {
                res[i] = st.peek();
            }
            st.push(curr);
        }
        return res;
    }
}
