package com.tw.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;


public class InputManager {
    private PrintStream printStream;
    private BufferedReader reader;
    private InputValidator validator;
    private InputParser parser;
    private Board board;

    public InputManager(PrintStream printStream, BufferedReader reader, InputValidator validator, InputParser parser, Board board) {

        this.printStream = printStream;
        this.reader = reader;
        this.validator = validator;
        this.parser = parser;
        this.board = board;
    }

    public int takeMove(int playerNumber) {
        boolean acceptableInput = true;
        int parsedInput = -1;
        do {
            printStream.print(String.format("Player %d next move: ", playerNumber));
            String input = readLine();
            if (!(acceptableInput = validator.isValidInput(input))) {
                printStream.println("That input is invalid. Please try again.");
            } else {
                parsedInput = parser.parse(input);
                if (!(acceptableInput = board.isSpaceOpen(parsedInput))) {
                    printStream.println("Location already taken.");
                }
            }
        } while (!acceptableInput);
        return parsedInput;
    }

    private String readLine() {
        String input;
        try {
            input = reader.readLine();
        } catch (IOException ioe) {
            throw new RuntimeException("IO Failure");
        }
        return input;
    }
}
