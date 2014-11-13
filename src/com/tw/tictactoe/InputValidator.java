package com.tw.tictactoe;


public class InputValidator {
    public boolean isValidInput(String input) {
        try {
            int parsedInput = Integer.valueOf(input);
            return !(parsedInput < 1 || parsedInput > 9);
        } catch (NumberFormatException nfe) {
            return false;
        }
    }
}
