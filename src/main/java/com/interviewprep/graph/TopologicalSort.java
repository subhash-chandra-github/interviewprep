package com.interviewprep.graph;

import java.util.LinkedList;
import java.util.Stack;

public class TopologicalSort {


    public static void dfsRec(int v, boolean[] visited, LinkedList<Integer>[] adj){
        visited[v] = true;
        System.out.print(v + "->");
        for (int n : adj[v]) {
            if (!visited[n]) {
                dfsRec(n, visited, adj);
            }
        }
    }

    public static void topologicalSort(boolean[] visited, Graph g){
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<g.getV();i++){
            if(!visited[i]){
                topologicalSortUtil(i,stack,visited,g.getAdj());
            }
        }
        while (!stack.isEmpty()){
            System.out.print(stack.pop() + "->");
        }
    }

    private static void topologicalSortUtil(int v, Stack<Integer> stack, boolean[] visited,  LinkedList<Integer>[] adj) {
        visited[v] = true;
        for (int n : adj[v]) {
            if (!visited[n]) {
                topologicalSortUtil(n,stack, visited, adj);
            }
        }
        stack.push(v);
    }

    public static void main(String[] args) {
        Graph g = new Graph(5);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 4);

        boolean[] visited = new boolean[5];
       // dfsRec(0,visited,g.getAdj());
        topologicalSort(visited,g);

    }
}
