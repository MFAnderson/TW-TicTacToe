package com.tw.tictactoe;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;

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
        Controller controller = new Controller(out, reader, validator, parser);
        Game game = new Game(controller, out, board, validator, parser);
        game.play();
    }
}
