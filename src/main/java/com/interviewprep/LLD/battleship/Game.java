package com.interviewprep.LLD.battleship;


import com.interviewprep.LLD.battleship.entities.Player;
import com.interviewprep.LLD.battleship.entities.PlayerChanceTarget;
import com.interviewprep.LLD.battleship.exceptions.CoordinateOutOfBoundaryException;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Game {

    Queue<Player> players;
    Queue<Player> winners;
    List<Player> gamePlayers;

    public Game() {
        this.players = new LinkedList<>();
        this.winners = new LinkedList<>();
        this.gamePlayers = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        this.players.add(player);
        this.gamePlayers.add(player);
    }

    public void start() {
        System.out.println("Starting game!");
        while (true) {
            final Player currentPlayer = players.poll();
            System.out.println("\n\nPlayer: " + currentPlayer.getId() + " chance:");
            final PlayerChanceTarget playerChanceTarget = currentPlayer.takeChance(this.gamePlayers);

            try {
                playerChanceTarget.getTargetPlayer().takeHit(playerChanceTarget.getTarget());
            } catch (CoordinateOutOfBoundaryException exception) {
                System.out.println("Hit was out of bounds.");
            }

            printSelfBoard(currentPlayer);
            printOpponentBoard(gamePlayers, currentPlayer);

            final Player winner = getWinner(gamePlayers);
            if (winner != null) {
                printWinner(winner);
                break;
            }
            this.players.add(currentPlayer);
        }
    }

    public Player getWinner(final List<Player> playerList) {
        final List<Player> alivePlayers = new ArrayList<>();
        for (Player player : playerList) {
            if (!player.areAllShipsKilled()) {
                alivePlayers.add(player);
            }
        }
        if (alivePlayers.size() == 1) {
            return alivePlayers.get(0);
        }
        return null;
    }

    public void printMsg(String msg) {
        System.out.println(msg);
    }

    public void printWinner(final Player player) {
        System.out.println("Game Finished!");
        System.out.println("Player: " + player.getId() + " won");
    }

    private void printPlayerInfo(final Player player) {
        printMsg("Player: " + player.getId());
    }
    public void printSelfBoard(final Player player) {
        printMsg("Your board status: ");
        printPlayerInfo(player);
        printMsg("Board boundary: " + player.getBoard().getBoundary());
        printMsg("Ships: " + player.getBoard().getShips());
        printMsg("Hit locations: " + player.getBoard().hitLocations());
        printMsg("Missed locations: " + player.getBoard().missLocations());
    }

    private void printOpponentBoard( final Player player) {
        printMsg("\nOpponent board status: ");
        printPlayerInfo(player);
        printMsg("Board boundary: " + player.getBoard().getBoundary());
        printMsg("Hit locations: " + player.getBoard().hitLocations());
        printMsg("Missed locations: " + player.getBoard().missLocations());
    }

    public void printOpponentBoard(final List<Player> allPlayers,final Player currentPlayer) {

        for (Player player : allPlayers) {
            if (player.getId() != currentPlayer.getId()) {
                printOpponentBoard(player);
            }
        }
    }
}
