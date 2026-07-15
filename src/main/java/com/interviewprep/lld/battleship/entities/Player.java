package com.interviewprep.lld.battleship.entities;

import com.interviewprep.lld.battleship.strategy.ChanceGenerationStrategy;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private Board board;
    private int id;
    private ChanceGenerationStrategy chanceGenerationStrategy;

    public Player(Board board, int id, ChanceGenerationStrategy chanceGenerationStrategy) {
        this.board = board;
        this.id = id;
        this.chanceGenerationStrategy = chanceGenerationStrategy;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ChanceGenerationStrategy getChanceGenerationStrategy() {
        return chanceGenerationStrategy;
    }

    public void setChanceGenerationStrategy(ChanceGenerationStrategy chanceGenerationStrategy) {
        this.chanceGenerationStrategy = chanceGenerationStrategy;
    }

    public PlayerChanceTarget takeChance(List<Player> allPlayers) {
        List<Player> opponents = new ArrayList<>();
        for (Player player: allPlayers) {
            if (player.getId() != getId()) {
                opponents.add(player);
            }
        }
        return chanceGenerationStrategy.getPlayerChanceTarget(opponents);
    }

    public boolean areAllShipsKilled() {
        return board.areAllShipsKilled();
    }

    public void takeHit(final Coordinate coordinate) {
        board.takeHit(coordinate);
    }
}
