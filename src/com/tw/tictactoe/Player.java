package com.tw.tictactoe;

/**
 * Created by manderso on 5/1/14.
 */
public class Player {

    private final int playerNumber;
    private final char playerSymbol;
    private Board board;
    private Controller controller;

    Player(int num, char symbol, Board board, Controller controller) {
        playerNumber = num;
        playerSymbol = symbol;
        this.board = board;
        this.controller = controller;
    }

    public int playerNumber() {return playerNumber;}

    public char playerSymbol() {return playerSymbol;}

    public void move() {
        int input = controller.takeMove(playerNumber);
        board.markSpace(input, playerSymbol);
    }
}
