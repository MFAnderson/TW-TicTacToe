package com.tw.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by manderso on 5/1/14.
 */
public class Controller {
    private PrintStream printStream;
    private BufferedReader reader;

    public Controller(PrintStream printStream, BufferedReader reader) {

        this.printStream = printStream;
        this.reader = reader;
    }

    public String takeMove(Player player) {
        String input;
        printStream.print(String.format("Player %d next move: ", player.playerNumber));
        try {
            input = reader.readLine();
        } catch (IOException ioe) {
            throw new RuntimeException("IO Failure");
        }
        return input;
    }
}
