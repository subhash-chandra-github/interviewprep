package com.interviewprep.LLD.chess.service;


import com.interviewprep.LLD.chess.entities.*;
import com.interviewprep.LLD.chess.enums.Color;
import com.interviewprep.LLD.chess.enums.GameStatus;

import java.util.List;
import java.util.Queue;

public class Game {

    private final Queue<Player> players;
    private final Queue<Player> winners;
    private final Board board;
    private final List<Move> movesPlayed;

    private GameStatus status;

    public Game(Queue<Player> players, Queue<Player> winners, Board board, List<Move> movesPlayed, GameStatus status) {
        this.players = players;
        this.winners = winners;
        this.board = board;
        this.movesPlayed = movesPlayed;
        this.status = status;
    }
    public void launch() throws Exception {
        board.resetBoard();
        while (players.size() > 1) {
            Player currPlayer = players.poll();
            System.out.println(currPlayer.getName()+"Enter your move ");
            playerMove(currPlayer,1,2,3,4);
            if(winners.size()>0){
                System.out.println("Player "+winners.poll().getName()+" wins");
                return;
            }else {
                players.add(currPlayer);
            }
        }
    }

    public boolean playerMove(Player player, int startX,
                              int startY, int endX, int endY) throws Exception {
        Spot startBox = board.getBox(startX, startY);
        Spot endBox = board.getBox(endX, endY);
        Move move = new Move(player, startBox, endBox);
        return this.makeMove(move, player);
    }

    private boolean makeMove(Move move, Player player)
    {
        Piece sourcePiece = move.getStart().getPiece();
        if (sourcePiece == null) {
            return false;
        }

        if (sourcePiece.getColor() != player.getColor()) {
            return false;
        }

        // valid move?
        if (!sourcePiece.canMove(board, move.getStart(),
                move.getEnd())) {
            return false;
        }

        // kill?
        Piece destPiece = move.getStart().getPiece();
        if (destPiece != null) {
            destPiece.setKilled(true);
            move.setPieceKilled(destPiece);
        }
        // castling?
        if (sourcePiece instanceof King
                && ((King) sourcePiece).isCastlingMove(move.getStart(),move.getEnd())) {
            move.setCastlingMove(true);
        }
        // store the move
        movesPlayed.add(move);
        // move piece from the stat box to end box
        move.getEnd().setPiece(move.getStart().getPiece());
        move.getStart().setPiece(null);

        if (destPiece instanceof King) {
            if (player.getColor().equals(Color.WHITE)) {
                this.setStatus(GameStatus.WHITE_WIN);
            }
            else {
                this.setStatus(GameStatus.BLACK_WIN);
            }
            winners.add(player);
        }
        return true;
    }

    public GameStatus getStatus() {
        return status;
    }

    public void setStatus(GameStatus status) {
        this.status = status;
    }
}
