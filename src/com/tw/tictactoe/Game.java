package com.tw.tictactoe;

import java.io.PrintStream;

/**
 * Created by manderso on 5/1/14.
 */
public class Game {
    private Controller controller;
    private PrintStream printStream;
    private Board board;

    public Game(Controller controller, PrintStream printStream, Board board) {

        this.controller = controller;
        this.printStream = printStream;
        this.board = board;
    }

    public void play() {
        board.drawBoard();
        while(!board.isFull()) {
            for (Player player : new Player[] {Player.ONE, Player.TWO}) {
                makeMove(player);
                board.drawBoard();
                if (board.isFull()) {
                    break;
                }
            }
        }
    }

    private void makeMove(Player player) {
        boolean canMakeMove = false;
        while (!canMakeMove) {
            int input = controller.takeMove(player.playerNumber);
            canMakeMove = board.isSpaceOpen(input);
            board.takeSpace(input, player);
            if (!canMakeMove) {
                printStream.println("Location already taken");
            }
        }
    }
}
