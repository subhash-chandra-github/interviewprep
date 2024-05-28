package com.interviewprep.LLD.battleship.entities;

import lombok.ToString;

import java.util.List;

@ToString
public class Ships {


    private String name;
    private Boundary boundary;

    public Ships(String name, Boundary boundary) {
        this.name = name;
        this.boundary = boundary;
    }

    public boolean isKilled(final List<Coordinate> hitLocations) {
        final List<Coordinate> shipCoordinates = boundary.allCoordinates();
        for (Coordinate shipCoordinate: shipCoordinates) {
            if (!hitLocations.contains(shipCoordinate)) {
                return false;
            }
        }
        return true;
    }

    public boolean containsCoordinate(final Coordinate coordinate) {
        return this.boundary.contains(coordinate);
    }
}
