package com.interviewprep.tests;

public class MazeSolverDP {

    public int minMoves(int[][] maze, int k) {
        int n = maze.length;
        int m = maze[0].length;

        if (maze[0][0] == 1 || maze[n - 1][m - 1] == 1) {
            return -1;
        }

        // Initialize a 2D array to store the minimum number of moves to reach each cell
        int[][] minMoves = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                minMoves[i][j] = Integer.MAX_VALUE;
            }
        }

        minMoves[0][0] = 0;

        // Define possible moves
        int[][] moves = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (minMoves[i][j] == Integer.MAX_VALUE) {
                    continue; // No need to process unreachable cells
                }

                for (int[] move : moves) {
                    for (int x = 1; x <= k; x++) {
                        int ni = i + x * move[0];
                        int nj = j + x * move[1];

                        if ( ni >=0 && ni < n &&  nj >=0 && nj < m && maze[ni][nj] == 0) {
                            minMoves[ni][nj] = Math.min(minMoves[ni][nj], minMoves[i][j] + 1);
                        }
                    }
                }
            }
        }

        if (minMoves[n - 1][m - 1] == Integer.MAX_VALUE) {
            return -1;
        } else {
            return minMoves[n - 1][m - 1];
        }
    }

    boolean isValidMove(int[][] maze, int i, int j, int x, int y, int m, int n){
//        if( x >=0 && x < n &&  y >=0 && y < m && maze[x][y] == 0)
//        if(x>i){
//
//        }
        return true;

    }
    public static void main(String[] args) {
        int[][] maze = {
                {0, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 0, 1, 0}
        };
        int k = 2;
        MazeSolverDP solver = new MazeSolverDP();
        int result = solver.minMoves(maze, k);
        System.out.println(result);  // Output: 4
    }
}