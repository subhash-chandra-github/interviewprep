package com.interviewprep.LLD.battleship;

import com.interviewprep.LLD.battleship.entities.*;
import com.interviewprep.LLD.battleship.input.InputProvider;
import com.interviewprep.LLD.battleship.input.SysInputProvider;
import com.interviewprep.LLD.battleship.strategy.LocalChanceGeneration;

import java.util.ArrayList;
import java.util.List;

public class Driver {


    public static void main(String[] args) {

        final InputProvider inputProvider = new SysInputProvider();
        Game game = new Game();
        game.addPlayer(getPlayer1(inputProvider));
        game.addPlayer(getPlayer2(inputProvider));
        game.start();
    }

    private static Player getPlayer1(final InputProvider inputProvider) {
        final Boundary boardBoundary = new Boundary(new Coordinate(0, 10), new Coordinate(10, 0));

        Ships ship1 = new Ships("Carrier", new Boundary(new Coordinate(0, 7), new Coordinate(4,7)));
        Ships ship2 = new Ships("Battleship", new Boundary(new Coordinate(4, 1), new Coordinate(4,4)));
        Ships ship3 = new Ships("Cruiser", new Boundary(new Coordinate(7, 3), new Coordinate(7, 5)));
        Ships ship4 = new Ships("Destroyer", new Boundary(new Coordinate(4, 9), new Coordinate(6,9)));
        Ships ship5 = new Ships("Submarine", new Boundary(new Coordinate(3, 6), new Coordinate(4,3)));

        ArrayList<Ships> ships = new ArrayList<>();
        ships.add(ship1);
        ships.add(ship2);
        ships.add(ship3);
        ships.add(ship4);
        ships.add(ship5);

        Board board = new Board(ships, boardBoundary);

        return new Player(board, 1, new LocalChanceGeneration(inputProvider));
    }

    private static Player getPlayer2(final InputProvider inputProvider) {
        final Boundary boardBoundary = new Boundary(new Coordinate(0, 10), new Coordinate(10, 0));


        Ships ship1 = new Ships("Carrier", new Boundary(new Coordinate(0, 7), new Coordinate(4,7)));
        Ships ship2 = new Ships("Battleship", new Boundary(new Coordinate(4, 1), new Coordinate(4,4)));
        Ships ship3 = new Ships("Cruiser", new Boundary(new Coordinate(7, 3), new Coordinate(7, 5)));
        Ships ship4 = new Ships("Destroyer", new Boundary(new Coordinate(4, 9), new Coordinate(6,9)));
        Ships ship5 = new Ships("Submarine", new Boundary(new Coordinate(3, 6), new Coordinate(4,3)));

        ArrayList<Ships> ships = new ArrayList<>();
        ships.add(ship1);
        ships.add(ship2);
        ships.add(ship3);
        ships.add(ship4);
        ships.add(ship5);

        Board board = new Board(ships, boardBoundary);

        return new Player(board, 2, new LocalChanceGeneration(inputProvider));
    }
}
