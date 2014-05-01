package com.tw.tictactoe;


import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
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

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        reader = mock(BufferedReader.class);
        controller = new Controller(printStream, reader);
    }

    @Test
    public void shouldPromptPlayer1ForMove() throws IOException {
        controller.takeMove();
        verify(printStream).print("Player 1 next move: ");
    }

    @Test
    public void shouldAcceptAUserInput() throws IOException {
        controller.takeMove();
        verify(reader).readLine();
    }

    @Test
    public void shouldReturnUserSelectedMove() throws IOException {
        String input = "1";
        when(reader.readLine()).thenReturn(input);
        assertThat(controller.takeMove(), is(input));
    }
}
