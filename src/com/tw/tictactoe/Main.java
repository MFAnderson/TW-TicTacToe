package com.tw.tictactoe;

/**
 * Created by manderso on 5/1/14.
 */
public class Main {
    public static void main(String[] args) {
        new Board(System.out, new boolean[3][3]).displayBoard();
    }
}
