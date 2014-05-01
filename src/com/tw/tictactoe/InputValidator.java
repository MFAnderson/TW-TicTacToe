package com.tw.tictactoe;

/**
 * Created by manderso on 5/1/14.
 */
public class InputValidator {
    public boolean validate(String input) {
        try {
            int parsedInput = Integer.valueOf(input);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }
}
