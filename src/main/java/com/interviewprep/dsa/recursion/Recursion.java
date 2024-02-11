package com.interviewprep.dsa.recursion;

import java.util.List;
import java.util.Stack;

public class Recursion {

    void print(int n){
        if(n==0){
            return;
        }
        print(n-1);
        System.out.print(n+" ");
    }


    void sort(List<Integer> lst){
        int s=lst.size();
        if(s==0){
            return;
        }
        Integer last = lst.remove(s-1);
        sort(lst);
        insert(lst,last);
    }

    void insert(List<Integer> lst, int e){
        int s = lst.size();
        if(s==0 || e > lst.get(s-1)){
            lst.add(e);
            return;
        }
        Integer last = lst.remove(s-1);
        insert(lst,e);
        lst.add(last);
    }

    void sortStack(Stack<Integer> stack){

        if(stack.empty()){
            return;
        }
        Integer e = stack.pop();
        sortStack(stack);
        insertStack(stack,e);
    }

    void insertStack(Stack<Integer> stack, int e){
        if(stack.empty() || e > stack.peek()){
            stack.push(e);
            return;
        }
        Integer last = stack.pop();
        insert(stack,e);
        stack.push(last);
    }
    void reverseStack(Stack<Integer> st){
        if(st.empty()){
            return;
        }
        Integer e = st.pop();
        reverseStack(st);
        st.push(e);

    }
    public static void main(String[] args) {
        Recursion r = new Recursion();
      //  r.print(10);
//        List<Integer> list = new ArrayList<>();
//        list.add(5);
//        list.add(1);
//        list.add(0);
//        list.add(3);
//        list.add(10);
//        list.add(8);
//        list.add(7);
//        list.add(4);
       // r.sort(list);
        Stack<Integer> st = new Stack<>();
        st.push(5); // 3 0 1 5
        st.push(1); // 5 1 0 3
        st.push(0);
        st.push(3);
        for(Integer a:st){
            System.out.print(a+" ");
        }
       // r.sortStack(st);
        r.reverseStack(st);
        System.out.println();
        for(Integer a:st){
            System.out.print(a+" ");
        }
    }
}
