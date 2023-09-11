package com.interviewprep.LLD.chess.service;

import com.interviewprep.LLD.chess.entities.Board;
import com.interviewprep.LLD.chess.entities.Player;
import com.interviewprep.LLD.chess.enums.Color;
import com.interviewprep.LLD.chess.enums.GameStatus;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Driver {

    public static void main(String[] args) {
        Player p1 = new Player(1,"A", Color.WHITE);
        Player p2 = new Player(2,"B", Color.BLACK);
        Board board = new Board();
        Queue<Player> players = new LinkedList<>();
        players.add(p1);
        players.add(p2);
        Queue<Player> winner = new LinkedList<>();
        Game chessGame = new Game(players,winner,board,new ArrayList<>(), GameStatus.ACTIVE);
        try {
            chessGame.launch();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

    }
}
