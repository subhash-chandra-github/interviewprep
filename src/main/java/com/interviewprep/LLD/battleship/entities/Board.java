package com.interviewprep.LLD.battleship.entities;

import com.interviewprep.LLD.battleship.exceptions.CoordinateOutOfBoundaryException;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Board {


        private Boundary boundary;
        private List<Ships> ships;
        private List<Coordinate> allBombLocations;

        public Board(List<Ships> ships,Boundary boundary) {
                this.boundary = boundary;
                this.ships = ships;
                this.allBombLocations = new ArrayList<>();
        }

        public void takeHit(final Coordinate coordinate) {
                if (!boundary.contains(coordinate)) {
                        throw new CoordinateOutOfBoundaryException();
                }
                allBombLocations.add(coordinate);
        }

        public boolean areAllShipsKilled() {
                for (Ships ship : ships) {
                        if (!ship.isKilled(allBombLocations)) {
                                return false;
                        }
                }
                return true;
        }

        public List<Coordinate> hitLocations() {
                final List<Coordinate> result = new ArrayList<>();
                for (Coordinate coordinate: allBombLocations) {
                        for (Ships ship: ships) {
                                if (ship.containsCoordinate(coordinate)) {
                                        result.add(coordinate);
                                        break;
                                }
                        }
                }

                return result;
        }

        public List<Coordinate> missLocations() {
                final List<Coordinate> result = new ArrayList<>();

                for (Coordinate coordinate: allBombLocations) {
                        boolean doesBelongToShip = false;
                        for (Ships ship: ships) {
                                if (ship.containsCoordinate(coordinate)) {
                                        doesBelongToShip = true;
                                        break;
                                }
                        }
                        if (!doesBelongToShip) {
                                result.add(coordinate);
                        }
                }

                return result;
        }
}
