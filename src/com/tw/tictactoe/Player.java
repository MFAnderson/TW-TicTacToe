package com.tw.tictactoe;


public class Player {

    private final int playerNumber;
    private final char playerSymbol;
    private Board board;
    private InputManager inputManager;

    Player(int num, char symbol, Board board, InputManager inputManager) {
        playerNumber = num;
        playerSymbol = symbol;
        this.board = board;
        this.inputManager = inputManager;
    }

    public int playerNumber() {return playerNumber;}

    public char playerSymbol() {return playerSymbol;}

    public void move() {
        int input = inputManager.takeMove(playerNumber);
        board.markSpace(input, playerSymbol);
    }
}
