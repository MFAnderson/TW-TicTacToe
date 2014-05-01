package com.tw.tictactoe;

import java.io.PrintStream;

/**
 * Created by manderso on 5/1/14.
 */
public class Board {
    private PrintStream printStream;
    private boolean[][] boardSpaces;
    private static final String horizontalSeparator = "\n-----\n";
    private static final String verticalSeparator = "|";

    public Board(PrintStream printStream, boolean[][] boardSpaces) {

        this.printStream = printStream;
        this.boardSpaces = boardSpaces;
    }
    //This is ugly as heck
    public void drawBoard() {
        String boardVisualization = "";
        for (int i = 0; i < boardSpaces.length; i++) {
            for (int j = 0; j < boardSpaces[i].length; j++) {
                if (boardSpaces[i][j]) {
                    boardVisualization += "X";
                } else {
                    boardVisualization += " ";
                }
                if (j+1 < boardSpaces[i].length) {
                    boardVisualization += verticalSeparator;
                }
            }
            if (i+1 < boardSpaces.length) {
                boardVisualization += horizontalSeparator;
            }
        }
        printStream.println(boardVisualization);
    }

    public void takeSpace(int input) {
        assert input > 0;
        int zeroIndexedInput = input - 1;
        int row = zeroIndexedInput / 3;
        int column = zeroIndexedInput % 3;
        boardSpaces[row][column] = true;
    }
}
