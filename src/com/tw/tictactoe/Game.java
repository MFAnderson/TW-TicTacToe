package com.tw.tictactoe;

import java.io.PrintStream;
import java.util.List;


public class Game {
    private PrintStream printStream;
    private Board board;
    private List<Player> players;

    public Game(PrintStream printStream, Board board, List<Player> players) {

        this.printStream = printStream;
        this.board = board;
        this.players = players;
    }

    public void play() {
        board.drawBoard();
        do {
            for (Player player : players) {
                player.move();
                board.drawBoard();
                if (board.isFull()) {
                    printStream.println("Game is a draw");
                    break;
                }
                if (board.hasWinner()) {
//                    printStream.println(String.format(""))
                    break;
                }
            }
        } while(!board.isFull() && !board.hasWinner());
    }
}
