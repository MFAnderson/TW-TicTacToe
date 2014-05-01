package com.tw.tictactoe;

import java.io.PrintStream;

/**
 * Created by manderso on 5/1/14.
 */
public class Game {
    private Controller controller;
    private PrintStream printStream;
    private Board board;
    private InputValidator parser;

    public Game(Controller controller, PrintStream printStream, Board board, InputValidator parser) {

        this.controller = controller;
        this.printStream = printStream;
        this.board = board;
        this.parser = parser;
    }

    public void play() {
        board.drawBoard();
        boolean haveValidInput = false;
        while (!haveValidInput) {
            String input = controller.takeMove();
            haveValidInput = parser.validate(input);
            if (!haveValidInput) {
                printStream.println("That input is invalid. Please try again.");
            } else {
                board.takeSpace(Integer.valueOf(input));
            }
        }
    }
}
