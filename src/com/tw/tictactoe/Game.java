package com.tw.tictactoe;

import java.io.PrintStream;
import java.util.List;

/**
 * Created by manderso on 5/1/14.
 */
public class Game {
    private Controller controller;
    private PrintStream printStream;
    private Board board;
    private List<Player> players;

    public Game(Controller controller, PrintStream printStream, Board board, List<Player> players) {

        this.controller = controller;
        this.printStream = printStream;
        this.board = board;
        this.players = players;
    }

    public void play() {
        board.drawBoard();
        while(!board.isFull()) {
            for (Player player : players) {
                player.move();
                board.drawBoard();
                if (board.isFull()) {
                    break;
                }
            }
        }
    }
}
