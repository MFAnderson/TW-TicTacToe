package com.tw.tictactoe;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by manderso on 5/1/14.
 */
public class Main {
    public static void main(String[] args) {
        PrintStream out = System.out;
        Board board = new Board(out, new char[9]);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        InputValidator validator = new InputValidator();
        InputParser parser = new InputParser();
        Controller controller = new Controller(out, reader, validator, parser, board);
        List<Player> players = new ArrayList<Player>();
        players.add(new Player(1, 'X', board, controller));
        players.add(new Player(2, 'O', board, controller));
        Game game = new Game(controller, out, board, players);
        game.play();
    }
}
