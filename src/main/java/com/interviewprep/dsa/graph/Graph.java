package com.interviewprep.dsa.graph;

import java.util.*;

/**
 * Created by subhash on 25/6/21.
 */
public class Graph {

    private int v;
    private List<List<Integer>> adj;

    Graph(int v) {
        this.v = v;
        this.adj = new ArrayList<>(v);
        for(int i=0;i<v;i++){
            adj.add(new ArrayList<>());
        }
    }

    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }

    public List<List<Integer>> getAdj() {
        return adj;
    }

    public void setAdj(List<List<Integer>> adj) {
        this.adj = adj;
    }

    void addEdge(int v, int w) {
        adj.get(v).add(w);
    }

    void dfs(int v, boolean visited[]) {
        Stack<Integer> st = new Stack<>();
        st.add(v);
        visited[v] = true;
        while (!st.isEmpty()) {
            int node = st.pop();
            visited[node] = true;
            System.out.print(node + "->");
            adj.get(node).forEach(e -> {
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
        for (int n : adj.get(v)) {
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
            adj.get(node).forEach(e -> {
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

     /*
        0-----1
         \    |
          \   |
           \  |
            \ |
       3-----2
       |
       4
                */

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
