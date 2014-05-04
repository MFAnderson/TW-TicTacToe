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
        while(!board.isFull()) {
            for (Player player : Player.values()) {
                makeMove(player);
                board.drawBoard();
                if (board.isFull()) {
                    break;
                }
            }
        }
    }

    private void makeMove(Player player) {
        boolean moveMade = false;
        while (!moveMade) {
            int input = controller.takeMove(player);
            moveMade = board.isSpaceOpen(input);
            board.takeSpace(input, player);
            if (!moveMade) {
                printStream.println("Location already taken");
            }
        }
    }
}
