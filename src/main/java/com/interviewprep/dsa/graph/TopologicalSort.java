package com.interviewprep.dsa.graph;

import java.util.*;

public class TopologicalSort {

    public static void topologicalSort(List<List<Integer>> adj, int v){

        int[] indegree = new int[v];
        for(List<Integer> list : adj){
            for(int vertex : list){
                indegree[vertex]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        List<Integer> result = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            result.add(node);
            // Decrease indegree of adjacent vertices as the
            // current node is in topological order
            for (int adjacent : adj.get(node)) {
                indegree[adjacent]--;
                // If indegree becomes 0, push it to the
                // queue
                if (indegree[adjacent] == 0)
                    q.add(adjacent);
            }
        }
        System.out.println(result);

    }

    public static void main(String[] args) {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(3, 1);
        g.addEdge(3, 2);
       // g.addEdge(3, 4);

        boolean[] visited = new boolean[5];
       // dfsRec(0,visited,g.getAdj());
        topologicalSort(g.getAdj(),g.getV());

    }
}
