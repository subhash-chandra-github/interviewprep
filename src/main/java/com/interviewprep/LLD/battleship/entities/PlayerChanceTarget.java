package com.interviewprep.LLD.battleship.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PlayerChanceTarget {

    final Player targetPlayer;
    final Coordinate target;
}
