package com.interviewprep.LLD.battleship.entities;

import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
public class Boundary {


    private final Coordinate topLeft;
    private final Coordinate bottomRight;

    public Boundary(Coordinate topLeft, Coordinate bottomRight) {
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
    }

    public List<Coordinate> allCoordinates() {
        List<Coordinate> coordinates = new ArrayList<>();
        for (int i = topLeft.getX(); i <= bottomRight.getX(); i++) {
            for (int j = topLeft.getY(); j >= bottomRight.getY(); j--) {
                coordinates.add(new Coordinate(i, j));
            }
        }
        return coordinates;
    }

    public boolean contains(final Coordinate coordinate) {
        return coordinate.getX() >= topLeft.getX() && coordinate.getX() <= bottomRight.getX()
                && coordinate.getY() >= bottomRight.getY() && coordinate.getY() <= topLeft.getY();
    }
}
