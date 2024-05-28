package com.interviewprep.LLD.battleship.strategy;

import com.interviewprep.LLD.battleship.entities.Coordinate;
import com.interviewprep.LLD.battleship.entities.Player;
import com.interviewprep.LLD.battleship.entities.PlayerChanceTarget;
import com.interviewprep.LLD.battleship.exceptions.InvalidInputException;
import com.interviewprep.LLD.battleship.input.InputProvider;
import com.interviewprep.LLD.battleship.input.PlayerInput;
import lombok.AllArgsConstructor;

import java.util.List;


@AllArgsConstructor
public class LocalChanceGeneration implements ChanceGenerationStrategy{

    private final InputProvider inputProvider;
    @Override
    public PlayerChanceTarget getPlayerChanceTarget(List<Player> opponents) {
        final PlayerInput playerInput = inputProvider.takeInput();
        Player targetPlayer = null;
        for (Player player: opponents) {
            if (player.getId() == playerInput.getPlayerNum()) {
                targetPlayer = player;
            }
        }

        if (targetPlayer == null) {
            throw new InvalidInputException();
        }
        return new PlayerChanceTarget(targetPlayer, new Coordinate(playerInput.getTargetX(), playerInput.getTargetY()));
    }
}
