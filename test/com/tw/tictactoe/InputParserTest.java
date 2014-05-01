package com.tw.tictactoe;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by manderso on 5/1/14.
 */
public class InputParserTest {

    @Test
    public void shouldReturnIntegerValueForValidInput() {
        assertThat(new InputParser().parse("1"), is(1));
    }

    @Test(expected = NumberFormatException.class)
    public void shouldThrowRuntimeExceptionOnInvalidInput() {
        new InputParser().parse("bad input");
    }
}
