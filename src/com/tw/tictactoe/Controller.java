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
    private InputValidator validator;
    private InputParser parser;

    public Controller(PrintStream printStream, BufferedReader reader, InputValidator validator, InputParser parser) {

        this.printStream = printStream;
        this.reader = reader;
        this.validator = validator;
        this.parser = parser;
    }

    public int takeMove(int playerNumber) {
        String input = null;
        boolean acceptableInput;
        do {
            try {
                printStream.print(String.format("Player %d next move: ", playerNumber));
                input = reader.readLine();
            } catch (IOException ioe) {
                throw new RuntimeException("IO Failure");
            }
            if (!(acceptableInput = validator.validate(input))) {
                printStream.println("That input is invalid. Please try again.");
            }
        } while (!acceptableInput);
        return parser.parse(input);
    }
}
