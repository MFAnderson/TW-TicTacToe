package com.tw.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by manderso on 5/1/14.
 */
public class GameTest {

    private Controller controller;
    private Game game;
    private PrintStream printStream;

    @Before
    public void setUp() throws Exception {
        controller = mock(Controller.class);
        printStream = mock(PrintStream.class);
        game = new Game(controller, printStream);
    }

    @Test
    public void shouldRequestMove() {
        game.play();
        verify(controller).takeMove();
    }

    @Test
    public void shouldInformOfInvalidInput() {
        when(controller.takeMove()).thenReturn("An Invalid Input");
        game.play();
        verify(printStream).println("That input is invalid. Please try again.");
    }
}
