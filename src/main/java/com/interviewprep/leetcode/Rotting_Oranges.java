package com.interviewprep.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Rotting_Oranges {

    public static void main(String[] args) {
        int[][] a = {{2,1,1},{1,1,1},{0,1,2}};
        Rotting_Oranges obj = new Rotting_Oranges();
        System.out.println(obj.orangesRotting(a));
    }
    class Pair{
        int i;
        int j;
        public Pair(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;
        Queue<Pair> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j)) ;
                }
                if(grid[i][j]==1){
                    ans++; ;
                }
            }
        }
        if(ans==0){
            return 0;
        }
        ans = 0;
        int[][] pos = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        while(!q.isEmpty()){
            int s = q.size();
            for(int i=0;i<s;i++){
                Pair p = q.poll();
                for(int k=0;k<4;k++){
                    int x = p.i + pos[k][0];
                    int y = p.j + pos[k][1];
                    if(x>=0 && x<n && y>=0 && y<m && grid[x][y]==1){
                        grid[x][y]=2;
                        q.add(new Pair(x,y));
                    }
                }
            }
        if(q.size()>0){
            ans++;
        }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    ans = -1;
                    break;
                }
            }
        }
        return ans;
    }
}