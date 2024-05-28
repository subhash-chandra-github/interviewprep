package com.interviewprep.LLD.battleship.entities;

import com.interviewprep.LLD.battleship.strategy.ChanceGenerationStrategy;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Player {

    private  Board board;
    private  int id;
    private ChanceGenerationStrategy chanceGenerationStrategy;

    public Player(Board board, int id, ChanceGenerationStrategy chanceGenerationStrategy) {
        this.board = board;
        this.id = id;
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
