package com.interviewprep.leetcode;

import java.util.ArrayList;

public class CycleInDirectedGraph {
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        boolean[] visited = new boolean[V];
        boolean[] inStack = new boolean[V];
        for(int i=0;i<V;i++){
            if(dfs(i,adj,visited,inStack)){
                return true;
            }
        }
        return false;
    }
    public boolean dfs(int v, ArrayList<ArrayList<Integer>> adj, boolean[] visited, boolean[] inStack){
        visited[v] = true;
        inStack[v] = true;

        for(Integer neighbour : adj.get(v)){
            if(!visited[neighbour]){
                if(dfs(neighbour,adj,visited,inStack)){
                    return true;
                }
            }else if(inStack[neighbour]){
                return true;
            }

        }
        inStack[v] = false;
        return false;

    }
}
