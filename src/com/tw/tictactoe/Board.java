package com.tw.tictactoe;

import java.io.PrintStream;

/**
 * Created by manderso on 5/1/14.
 */
public class Board {
    private PrintStream printStream;

    public Board(PrintStream printStream) {

        this.printStream = printStream;
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
}
