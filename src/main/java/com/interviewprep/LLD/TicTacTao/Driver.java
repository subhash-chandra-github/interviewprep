package com.interviewprep.LLD.TicTacTao;


public class Driver {

    public static void main(String[] args) {
        Game game= new Game();
        game.addPlayer(new Player(1,"A",'X'));
        game.addPlayer(new Player(2,"B",'O'));
        game.launch();
    }
}
