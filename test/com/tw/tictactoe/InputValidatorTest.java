package com.tw.tictactoe;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by manderso on 5/1/14.
 */
public class InputValidatorTest {

    private InputValidator validator;

    @Before
    public void setUp() throws Exception {
        validator = new InputValidator();
    }

    @Test
    public void shouldReturnTrueIfAValidInteger() {
        assertThat(validator.validate("1"), is(true));
    }

    @Test
    public void shouldReturnFalseIfOutsideOfRange() {
        assertThat(validator.validate("10"), is(false));
    }

    @Test
    public void shouldReturnFalseIfNonIntegerInput() {
        assertThat(validator.validate("A non integer"), is(false));
    }

}
