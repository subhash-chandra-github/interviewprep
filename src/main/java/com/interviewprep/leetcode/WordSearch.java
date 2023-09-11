package com.interviewprep.leetcode;

public class WordSearch {

    public static void main(String[] args) {

        char board[][] = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String w = "SEE";

        System.out.println(exist(board, w));
    }

    public static boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0) &&findWord(board, word, 0, i, j, m, n, visited)){
                    return true;
                }
            }
        }
        return false;
    }


    public static boolean findWord(char[][] board, String word, int s, int i, int j, int m, int n, boolean[][] visited) {

        if (s<=word.length()) {
            return true;
        }

        if (i < 0 || j < 0 || i >= m || j >= n || visited[i][j] || board[i][j]!=word.charAt(s))
            return false;

        visited[i][j] = true;
        if (findWord(board, word, s+1, i + 1, j, m, n, visited)
                || findWord(board, word, s+1, i, j + 1, m, n, visited)
                || findWord(board, word, s+1, i - 1, j, m, n, visited)
                || findWord(board, word, s+1, i, j - 1, m, n, visited)) {
            return true;
        }
        visited[i][j] = false;

        return false;

    }

}
