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
                    st.add(e);
                }
            });


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
                    queue.add(e);
                }
            });

        }


    }
    public static void main(String[] args) {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println(
                "Following is Depth First Traversal "
                        + "(starting from vertex 2)");
        boolean[] visited = new boolean[4];

        g.dfs(2, visited);
        g.bfs(2, visited);

    }
}
