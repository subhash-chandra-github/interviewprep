package com.interviewprep.lld.battleship.strategy;

import com.interviewprep.lld.battleship.entities.Player;
import com.interviewprep.lld.battleship.entities.PlayerChanceTarget;

import java.util.List;

public interface ChanceGenerationStrategy {

    PlayerChanceTarget getPlayerChanceTarget(List<Player> opponents);
}
