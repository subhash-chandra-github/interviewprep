package com.interviewprep.dsa.backtracking;

import java.util.ArrayList;
import java.util.List;

public class RatMaze {


    public static void main(String[] args) {

        int[][] m = {{1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}};

        ArrayList<String> path = new ArrayList<>();
        boolean[][] visited = new boolean[4][4];
        findPath(0, 0,m,m.length,m[0].length, "", path, visited);
        for (String s : path) {
            System.out.println(s);
        }

    }
    public static void findPath(int r, int c, int[][] maze, int n, int m,
                      String s, List<String> ans, boolean[][] visited) {

        if (!isAllowed(r, c, maze) || visited[r][c]) return;

        if (r == n-1 && c == m-1) {
            ans.add(s);
            return;
        }

        visited[r][c] = true;

        findPath(r+1, c, maze, n, m, s+'D', ans, visited); // D  ← 1st
        findPath(r, c-1, maze, n, m, s+'L', ans, visited); // L  ← 2nd
        findPath(r, c+1, maze, n, m, s+'R', ans, visited); // R  ← 3rd
        findPath(r-1, c, maze, n, m, s+'U', ans, visited); // U  ← 4th

        visited[r][c] = false;
    }

    public static boolean isAllowed(int r, int c, int[][] maze) {
        int n = maze.length;
        int m = maze[0].length;
        if (r < 0 || r >= n) return false;
        if (c < 0 || c >= m) return false;
        if (maze[r][c] == 0)  return false;
        return true;
    }
}
