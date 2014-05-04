package com.tw.tictactoe;


import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by manderso on 5/1/14.
 */
public class ControllerTest {

    private PrintStream printStream;
    private BufferedReader reader;
    private Controller controller;
    private InputValidator validator;
    private InputParser parser;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        reader = mock(BufferedReader.class);
        validator = mock(InputValidator.class);
        parser = mock(InputParser.class);
        when(validator.validate(anyString())).thenReturn(true);
        controller = new Controller(printStream, reader, validator, parser);
    }

    @Test
    public void shouldPromptPlayer1ForMove() throws IOException {
        controller.takeMove(1);
        verify(printStream).print("Player 1 next move: ");
    }

    @Test
    public void shouldAcceptAUserInput() throws IOException {
        controller.takeMove(1);
        verify(reader).readLine();
    }

    @Test
    public void shouldPromptPlayer2ForMove() {
        controller.takeMove(2);
        verify(printStream).print("Player 2 next move: ");
    }

    @Test
    public void shouldInformOfInvalidInput() {
        when(validator.validate(anyString())).thenReturn(false).thenReturn(true);
        controller.takeMove(1);
        verify(printStream).println("That input is invalid. Please try again.");
    }
    @Test
    public void shouldParseUserInput() throws IOException {
        when(reader.readLine()).thenReturn("1");
        controller.takeMove(1);
        verify(parser).parse("1");
    }
    @Test
    public void shouldReturnParsedInput() {
        when(parser.parse(anyString())).thenReturn(2);
        int move = controller.takeMove(1);
        assertThat(move, is(2));
    }
}
