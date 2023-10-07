package com.interviewprep.graph;

import java.util.*;

/**
 * Created by subhash on 25/6/21.
 */
public class Graph {

    private int v;
    private LinkedList<Integer> adj[];

    Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }

    }

    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }

    public LinkedList<Integer>[] getAdj() {
        return adj;
    }

    public void setAdj(LinkedList<Integer>[] adj) {
        this.adj = adj;
    }

    void addEdge(int v, int w) {
        adj[v].add(w); // Add w to v's list.
    }

    void dfs(int v, boolean visited[]) {
        Stack<Integer> st = new Stack<>();
        st.add(v);
        visited[v] = true;
        while (!st.isEmpty()) {
            int node = st.pop();
            visited[node] = true;
            System.out.print(node + "->");
            adj[node].forEach(e -> {
                if (!visited[e]) {
                    visited[e] = true;
                    st.add(e);
                }
            });


        }
    }

    void dfsRec(int v, boolean visited[]){
        visited[v] = true;
        System.out.print(v + "->");
        for (int n : adj[v]) {
            if (!visited[n]) {
                dfsRec(n, visited);
            }
        }
    }
    void bfs(int v, boolean visited[]) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = true;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            visited[node] = true;
            System.out.print(node + "->");
            adj[node].forEach(e -> {
                if (!visited[e]) {
                    visited[e] = true;
                    queue.add(e);
                }
            });

        }


    }
    public static void main(String[] args) {
        Graph g = new Graph(5);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 4);

        System.out.println(
                "Following is Depth First Traversal "
                        + "(starting from vertex 0)");
        boolean[] visited = new boolean[5];

        g.dfs(0, visited);
        System.out.println();
        visited = new boolean[5];
        g.dfsRec(0,visited);
//        System.out.println(
//                "Following is Breadth First Traversal "
//                        + "(starting from vertex 0)");
//        g.bfs(0, visited);

    }
}
