package com.interviewprep.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SafeNodes {

    public static void main(String[] args) {

        int[][] graph =  {{1,2},{2,3},{5},{0},{5},{},{}};

        List<Integer> ans = eventualSafeNodes(graph);
        System.out.println(ans);
    }

    public static List<Integer> eventualSafeNodes(int[][] graph) {

        List<Integer> ans = new ArrayList<>();
        int n = graph.length;

        boolean[] visited = new boolean[n];
        boolean[] inStack = new boolean[n];
        for(int i=0;i<graph.length;i++){
            dfs(i,graph,visited,inStack);
        }
        for (int i = 0; i < n; i++) {
            if (!inStack[i]) {
                ans.add(i);
            }
        }
        return ans;


    }

    public static boolean dfs(int node, int[][] adj, boolean[] visit, boolean[] inStack) {
        // If the node is already in the stack, we have a cycle.
        if (inStack[node]) {
            return true;
        }
        if (visit[node]) {
            return false;
        }
        // Mark the current node as visited and part of current recursion stack.
        visit[node] = true;
        inStack[node] = true;
        for (int neighbor : adj[node]) {
            if (dfs(neighbor, adj, visit, inStack)) {
                return true;
            }
        }
        // Remove the node from the stack.
        inStack[node] = false;
        return false;
    }
}
