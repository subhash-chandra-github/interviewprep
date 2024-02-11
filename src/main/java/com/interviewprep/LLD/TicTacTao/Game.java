package com.interviewprep.LLD.TicTacTao;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Game {

    private final Board board;
    private final Queue<Player> players;

    public Game() {
        this.board = new Board();
        this.players = new LinkedList<>();
    }

    public void addPlayer(Player player)
    {
        this.players.add(player);
    }
    public void launch() {
        this.board.print();
        while (players.size() > 1) {

            Player currPlayer = players.poll();
            System.out.println();
            System.out.println(currPlayer.getName()+"'s turn.");
            System.out.println("Enter position");

            Scanner sc = new Scanner(System.in);
            int i = sc.nextInt();
            int j = sc.nextInt();
            makeMove(currPlayer,i,j);
            if(checkResult(i,j, currPlayer.getSymbol())){
                System.out.println("Winner is "+currPlayer.getName());
            }else {
                players.add(currPlayer);
                this.board.print();
            }
        }
    }

    private boolean checkResult(int row, int col, char c) {
        char[][] grid = board.getCells();
        int n = 3;

        boolean rowLine = true;
        for (int i = 0; i < n; i++) {
            rowLine = rowLine && (grid[i][col] == c);
        }
        // check vertical
        boolean colLine = true;
        for (int j = 0; j < n; j++) {
            colLine = colLine && (grid[row][j] == c);
        }
        // check diagonal
        if (row + col == n - 1 || row == col) {
            boolean diagLine1 = true;
            boolean diagLine2 = true;
            for (int j = 0; j < n; j++) {
                diagLine1 = diagLine1 && (grid[j][j] == c);
            }
            for (int j = 0; j < n; j++) {
                diagLine2 = diagLine2 && (grid[n - 1 - j][j] == c);
            }
            return rowLine || colLine || diagLine1 || diagLine2;
        } else {
            return rowLine || colLine;
        }
    }


    private boolean makeMove(Player currPlayer, int i, int j) {
        if(board.getCells()[i][j]=='-'){
            board.getCells()[i][j] = currPlayer.getSymbol();
            return true;
        }else {
            return false;
        }
    }

}
