package com.tw.tictactoe;

/**
 * Created by manderso on 5/1/14.
 */
public enum Player { ONE(1), TWO(2);
    public final int playerNumber;
    Player(int num) {
        playerNumber = num;
    }
}
