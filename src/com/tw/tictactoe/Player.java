package com.tw.tictactoe;

/**
 * Created by manderso on 5/1/14.
 */
public enum Player { ONE(1, 'X'), TWO(2, 'O');

    public final int playerNumber;
    public final char playerSymbol;

    Player(int num, char symbol) {
        playerNumber = num;
        playerSymbol = symbol;
    }
}
