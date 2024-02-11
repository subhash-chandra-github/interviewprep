package com.interviewprep.leetcode;

import java.util.ArrayList;

public class CycleInAGraph {

    // Function to detect cycle in a directed graph.
    int[] state;
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        state  = new int[V];
        for(int i=0;i<V;i++){
            if(!dfs(i,adj)){
                return true;
            }
        }
        return false;
    }
    public boolean dfs(int v, ArrayList<ArrayList<Integer>> adj){
        if(state[v]==2){
            return true;
        }
        if(state[v]==1){
            return false;
        }
        state[v]=1;
        for(int c : adj.get(v)){
            if(!dfs(c,adj)){
                return false;
            }
        }
        state[v]=2;
        return true;
    }
}
