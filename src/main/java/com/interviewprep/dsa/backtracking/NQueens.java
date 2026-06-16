package com.interviewprep.dsa.backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueens {

    public static void main(String[] args) {
        NQueens nQueens = new NQueens();
        List<List<String>> res = nQueens.solveNQueens(4);
        System.out.println(res.toString());
    }
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        List<List<String>> res = new ArrayList<>();
        dfs(0, board, res);
        return res;


    }

    private static void dfs(int col, char[][] board, List<List<String>> res) {
        if (col == board.length) {
            res.add(construct(board));
            return;
        }

        for (int row = 0; row < board.length; row++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q';
                dfs(col + 1, board, res);
                board[row][col] = '.';
            }
        }
    }


    private static List<String> construct(char[][] board) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            res.add(new String(board[i]));
        }
        return res;
    }


    private static boolean isSafe(char[][] board, int row, int col) {
        for (int c = 0; c < col; c++) {
            if (board[row][c] == 'Q') return false;
        }
        for (int r = row - 1, c = col - 1; r >= 0 && c >= 0; r--, c--) {
            if (board[r][c] == 'Q') return false;
        }
        for (int r = row + 1, c = col - 1; c >= 0 && r < board.length; r++, c--) {
            if (board[r][c] == 'Q') return false;
        }
        return true;
    }

}
