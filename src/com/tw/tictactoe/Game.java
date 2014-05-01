package com.tw.tictactoe;

import java.io.PrintStream;

/**
 * Created by manderso on 5/1/14.
 */
public class Game {
    private Controller controller;
    private PrintStream printStream;
    private Board board;
    private InputValidator validator;
    private InputParser parser;

    public Game(Controller controller, PrintStream printStream, Board board, InputValidator validator, InputParser parser) {

        this.controller = controller;
        this.printStream = printStream;
        this.board = board;
        this.validator = validator;
        this.parser = parser;
    }

    public void play() {
        board.drawBoard();
        boolean haveValidInput = false;
        while (!haveValidInput) {
            String input = controller.takeMove(Player.ONE);
            haveValidInput = validator.validate(input);
            if (!haveValidInput) {
                printStream.println("That input is invalid. Please try again.");
            } else {
                board.takeSpace(parser.parse(input), Player.ONE);
            }
        }
        board.drawBoard();
        haveValidInput = false;
        while (!haveValidInput) {
            String input = controller.takeMove(Player.TWO);
            haveValidInput = validator.validate(input);
            if (!haveValidInput) {
                printStream.println("That input is invalid. Please try again.");
            } else {
                board.takeSpace(parser.parse(input), Player.TWO);
            }
        }
        board.drawBoard();
    }
}
