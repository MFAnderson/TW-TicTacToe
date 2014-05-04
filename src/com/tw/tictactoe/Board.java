package com.tw.tictactoe;

import java.io.PrintStream;

/**
 * Created by manderso on 5/1/14.
 */
public class Board {
    private PrintStream printStream;
    private Player[] boardSpaces;
    private static final String horizontalSeparator = "\n-----\n";
    private static final String verticalSeparator = "|";

    public Board(PrintStream printStream, Player[] boardSpaces) {

        this.printStream = printStream;
        this.boardSpaces = boardSpaces;
    }
    //This is marginally less ugly than before, but still ugly
    public void drawBoard() {
        String boardVisualization = "";
        for (int i = 0; i < boardSpaces.length; i++) {
            if (boardSpaces[i] == null) {
                boardVisualization += " ";
            } else {
                boardVisualization += boardSpaces[i].playerSymbol;
            }
            if (i+1 < boardSpaces.length) {
                if ((i+1)%3 == 0) {
                    boardVisualization += horizontalSeparator;
                } else {
                    boardVisualization += verticalSeparator;
                }
            }
        }
        printStream.println(boardVisualization);
    }

    public boolean takeSpace(int input, Player player) {
        assert input > 0;
        int zeroIndexedInput = input - 1;
        if (boardSpaces[zeroIndexedInput] == null) {
            boardSpaces[zeroIndexedInput] = player;
            return true;
        } else {
            return false;
        }

    }

    public boolean isFull() {
        for (Player player : boardSpaces) {
            if (player == null) {
                return false;
            }
        }
        return true;
    }
}
