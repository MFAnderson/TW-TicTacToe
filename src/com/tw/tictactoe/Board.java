package com.tw.tictactoe;

import java.io.PrintStream;
import java.util.Arrays;

/**
 * Created by manderso on 5/1/14.
 */
public class Board {
    private PrintStream printStream;
    private char[] boardSpaces;
    private static final String horizontalSeparator = "\n-----\n";
    private static final String verticalSeparator = "|";

    public Board(PrintStream printStream, char[] boardSpaces) {

        this.printStream = printStream;
        this.boardSpaces = boardSpaces;
        Arrays.fill(boardSpaces, ' ');
    }

    public void drawBoard() {
        printStream.println(
                boardSpaces[0] + "|" + boardSpaces[1] + "|" + boardSpaces[2] + "\n"
            +   "-----" + "\n"
            +   boardSpaces[3] + "|" + boardSpaces[4] + "|" + boardSpaces[5] + "\n"
            +   "-----" + "\n"
            +   boardSpaces[6] + "|" + boardSpaces[7] + "|" + boardSpaces[8]
        );

    }

    public void takeSpace(int input, Player player) {
        assert input > 0;
        int zeroIndexedInput = input - 1;
        if (boardSpaces[zeroIndexedInput] == ' ') {
            boardSpaces[zeroIndexedInput] = player.playerSymbol;
        }

    }
    public boolean isSpaceOpen(int space) {
        int zeroIndexedSpace = space - 1;
        return boardSpaces[zeroIndexedSpace] == ' ';
    }
    public boolean isFull() {
        for (char c : boardSpaces) {
            if (c == ' ') {
                return false;
            }
        }
        return true;
    }

    public char findWinner() {
        for (int rowOffset = 0; rowOffset < 9; rowOffset+= 3) {
            if (boardSpaces[0 + rowOffset] == boardSpaces[1 + rowOffset]) {
                if(boardSpaces[0 + rowOffset] == boardSpaces[2 + rowOffset]) {
                    return boardSpaces[0 + rowOffset];
                }
            }
        }
        for (int column = 0; column < 3; column ++) {
            if (boardSpaces[column] == boardSpaces[column + 3]) {
                if (boardSpaces[column] == boardSpaces[column + 6]) {
                    return boardSpaces[column];
                }
            }
        }
        if (boardSpaces[0] == boardSpaces[4]) {
            if (boardSpaces[0] == boardSpaces[8]) {
                return boardSpaces[0];
            }
        }
        return ' ';
    }
}
