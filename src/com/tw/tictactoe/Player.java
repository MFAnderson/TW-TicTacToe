package com.tw.tictactoe;

/**
 * Created by manderso on 5/1/14.
 */
public class Player {
    public static final Player ONE = new Player(1, 'X');
    public static final Player TWO = new Player(2, 'O');

    public final int playerNumber;
    public final char playerSymbol;

    Player(int num, char symbol) {
        playerNumber = num;
        playerSymbol = symbol;
    }
}
