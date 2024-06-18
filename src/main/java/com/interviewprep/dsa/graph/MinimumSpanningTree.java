package com.interviewprep.dsa.graph;

import java.util.List;
import java.util.PriorityQueue;

public class MinimumSpanningTree {

    class Pair implements Comparable<Pair>{

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

    public  int spanningTree(int V, int E, List<List<int[]>> adj) {
        // Code Here.
        boolean[] visited = new boolean[V];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0,0));
        int ans = 0;
        while(!pq.isEmpty()){
            Pair cur = pq.poll();
            int u = cur.v;
            if(visited[u]){
                continue;
            }
            ans = ans+cur.wt;
            visited[u] = true;

            List<int[]> neighbours = adj.get(u);
            for(int[] l : neighbours){
                int vertex = l[0];
                int wt = l[1];
                if(!visited[vertex]){
                    pq.add(new Pair(vertex,wt));
                }
            }
        }
        return ans;
    }
}
