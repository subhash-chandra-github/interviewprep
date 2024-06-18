package com.interviewprep.dsa.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Dijkstra {

    static class Pair implements Comparable<Pair>{

        int v;
        int wt;

        public Pair(int v, int wt){
            this.v = v;
            this.wt = wt;
        }

        @Override
        public int compareTo(Pair that) {
            return this.wt-that.wt;
        }
    }
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        boolean[] visited = new boolean[V];
        int[] ans = new int[V];
        Arrays.fill(ans,Integer.MAX_VALUE);
        ans[S] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(S,0));
        while(!pq.isEmpty()){
            Pair cur = pq.poll();
            int u = cur.v;
            if(visited[u]){
                continue;
            }
            visited[u] = true;
            ArrayList<ArrayList<Integer>> neighbours = adj.get(u);
            for(ArrayList<Integer> l : neighbours){
                int vertex = l.get(0);
                int wt = l.get(1);
                if(ans[vertex] > ans[u]+wt){
                    ans[vertex] = ans[u]+wt;
                    pq.add(new Pair(vertex,ans[vertex]));
                }
            }
        }
        return ans;
    }
}
