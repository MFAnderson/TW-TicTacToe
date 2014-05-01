package com.tw.tictactoe;

import java.io.PrintStream;

/**
 * Created by manderso on 5/1/14.
 */
public class Board {
    private PrintStream printStream;
    private boolean[][] boardSpaces;

    public Board(PrintStream printStream, boolean[][] boardSpaces) {

        this.printStream = printStream;
        this.boardSpaces = boardSpaces;
    }

    public void displayBoard() {
        String row = " | | ";
        String horizontalSeparator = "-----";
        String boardVisualization = row;
        boardVisualization += "\n";
        boardVisualization += horizontalSeparator;
        boardVisualization += "\n";
        boardVisualization += row;
        boardVisualization += "\n";
        boardVisualization += horizontalSeparator;
        boardVisualization += "\n";
        boardVisualization += row;
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
