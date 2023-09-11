package com.interviewprep.coreJava;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {

    private Queue<Integer> q1;
    private Queue<Integer> q2;

    StackUsingQueue(){
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int x){
        q1.add(x);
    }

    public int pop(){
        int e;
        while(!q1.isEmpty()){
            if(q1.size()==1){
                e = q1.poll();
                swap();
                return e;
            }
            e = q1.poll();
            q2.add(e);
        }
        return -1;
    }

    private void swap(){

        Queue<Integer>  temp = this.q1;
        this.q1=this.q2;
        this.q2=temp;

    }

    public int top(){
        int e;
        while(!q1.isEmpty()){
            if(q1.size()==1){
                e = q1.peek();
                return e;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        StackUsingQueue st = new StackUsingQueue();

        st.push(5);
        st.push(6);
        st.push(9);

        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.top());
    }
}
