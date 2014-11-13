package com.tw.tictactoe;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        PrintStream out = System.out;
        Board board = new Board(out, new char[9]);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        InputValidator validator = new InputValidator();
        InputParser parser = new InputParser();
        InputManager inputManager = new InputManager(out, reader, validator, parser, board);
        List<Player> players = new ArrayList<Player>();
        players.add(new Player(1, 'X', board, inputManager));
        players.add(new Player(2, 'O', board, inputManager));
        Game game = new Game(out, board, players);
        game.play();
    }
}
