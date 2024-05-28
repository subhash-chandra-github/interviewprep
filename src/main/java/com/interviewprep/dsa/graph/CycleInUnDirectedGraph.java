package com.interviewprep.dsa.graph;

import java.util.ArrayList;

public class CycleInUnDirectedGraph {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] visited = new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i]){
                if(dfs(i,visited,adj,-1)){
                    return true;
                }
            }
        }
        return false;

    }

    boolean dfs(int v,boolean[] visited,ArrayList<ArrayList<Integer>> adj, int parent){
        visited[v] = true;
        for(Integer neighbour : adj.get(v)){
            if(!visited[neighbour]){
                if(dfs(neighbour,visited,adj,v)){
                    return true;
                }
            }
            else if(neighbour != parent){
                return true;
            }
        }
        return false;
    }
}
