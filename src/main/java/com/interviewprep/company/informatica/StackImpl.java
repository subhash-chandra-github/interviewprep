package com.interviewprep.company.informatica;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by subhash on 31/10/2022.
 */
public class StackImpl {



    private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();

    private void push(int k){

        q1.add(k);
    }

    private int pop() throws Exception {

        if(q1.isEmpty()){
            throw new Exception("No element present in stack");
        }
        int s = q1.size();
        while(s>1){
            int e = q1.poll();
            q2.add(e);
            s--;
        }
        int element = q1.poll();
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
        return element;
    }

    public static void main(String[] args) throws Exception {

        StackImpl st = new StackImpl();

        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        System.out.println(st.pop());
        System.out.println(st.pop());

        st.push(5);
        System.out.println(st.pop());
        System.out.println(st.q1);

    }
}
