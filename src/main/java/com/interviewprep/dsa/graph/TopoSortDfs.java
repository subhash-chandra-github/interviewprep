package com.interviewprep.dsa.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TopoSortDfs {

    public static void main(String[] args) {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(3, 1);
        g.addEdge(3, 2);
        int[] ans = topoSort(g.getV(), g.getAdj());
        for (int an : ans) {
            System.out.print(an + " ");
        }

    }

    static int[] topoSort(int V, List<List<Integer>> adj) {
        boolean[] vis = new boolean[V];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(i, st, vis, adj);
            }
        }
        int[] ans = new int[V];
        int i = 0;
        while (!st.isEmpty()) {
            ans[i++] = st.pop();
        }
        return ans;
    }

    static void dfs(int v, Stack<Integer> st,
                    boolean[] vis, List<List<Integer>> adj) {

        vis[v] = true;
        for (int neighbour : adj.get(v)) {
            if (!vis[neighbour]) {
                dfs(neighbour, st, vis, adj);
            }
        }
        st.push(v);
    }
}
