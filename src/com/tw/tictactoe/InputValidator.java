package com.tw.tictactoe;

/**
 * Created by manderso on 5/1/14.
 */
public class InputValidator {
    public boolean validate(String input) {
        try {
            int parsedInput = Integer.valueOf(input);
            if (parsedInput < 1 || parsedInput > 9) {
                return false;
            } else {
                return true;
            }
        } catch (NumberFormatException nfe) {
            return false;
        }
    }
}
