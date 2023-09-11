package com.interviewprep.backtracking;

import java.util.ArrayList;

public class RatMaze {

    private static ArrayList<String> path = new ArrayList<>();

    public static void main(String[] args) {

        int[][] m = {{1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}};

        // Your code here
        boolean[][] visited = new boolean[4][4];
        findPath(m, 0, 0, "", 4, visited);
        for (String s : path) {
            System.out.println(s);
        }

    }

    static void findPath(int[][] m, int i, int j, String s, int n, boolean[][] visited) {

        if (i == -1 || i == n || j == -1 ||
                j == n || visited[i][j] ||
                m[i][j] == 0)
            return;

        if (i == n - 1 && j == n - 1) {
            path.add(s);
            return;
        }

        visited[i][j]=true;
        if (isValidStep(m, i + 1, j, n, visited)) {
            s = s + 'D';

            findPath(m, i + 1, j, s, n, visited);
            s = s.substring(0, s.length() - 1);
        }

        if (isValidStep(m, i - 1, j, n, visited)) {
            s = s + 'U';
            findPath(m, i - 1, j, s, n, visited);
            s = s.substring(0, s.length() - 1);
        }

        if (isValidStep(m, i, j + 1, n, visited)) {
            s = s + 'R';
            findPath(m, i, j + 1, s, n, visited);
            s = s.substring(0, s.length() - 1);
        }

        if (isValidStep(m, i, j - 1, n, visited)) {
            s = s + 'L';
            findPath(m, i, j - 1, s, n, visited);
            s = s.substring(0, s.length() - 1);
        }
        visited[i][j]=false;

    }

    static boolean isValidStep(int[][] m, int row, int col, int n, boolean[][] visited) {
        if (row == -1 || row == n || col == -1 ||
                col == n || visited[row][col] ||
                m[row][col] == 0)
            return false;

        return true;
    }
}
