package com.interviewprep.LLD.battleship.strategy;

import com.interviewprep.LLD.battleship.entities.Player;
import com.interviewprep.LLD.battleship.entities.PlayerChanceTarget;

import java.util.List;

public interface ChanceGenerationStrategy {

    PlayerChanceTarget getPlayerChanceTarget(List<Player> opponents);
}
