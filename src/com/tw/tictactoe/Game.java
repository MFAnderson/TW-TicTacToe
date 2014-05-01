package com.tw.tictactoe;

import java.io.PrintStream;

/**
 * Created by manderso on 5/1/14.
 */
public class Game {
    private Controller controller;
    private PrintStream printStream;

    public Game(Controller controller, PrintStream printStream) {

        this.controller = controller;
        this.printStream = printStream;
    }

    public void play() {
        String input = controller.takeMove();
        if (input.equals("An Invalid Input")) {
            printStream.println("That input is invalid. Please try again.");
        }
    }
}
