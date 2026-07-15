package com.interviewprep.lld.battleship.entities;

public class PlayerChanceTarget {

    final Player targetPlayer;
    final Coordinate target;

    public PlayerChanceTarget(Player targetPlayer, Coordinate target) {
        this.targetPlayer = targetPlayer;
        this.target = target;
    }

    public Player getTargetPlayer() {
        return targetPlayer;
    }

    public Coordinate getTarget() {
        return target;
    }

    public void setTargetPlayer(Player targetPlayer) {
        // final field, cannot set
    }

    public void setTarget(Coordinate target) {
        // final field, cannot set
    }
}
