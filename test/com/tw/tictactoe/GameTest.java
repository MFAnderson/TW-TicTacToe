package com.tw.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Matchers.anyString;
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
    private Board board;
    private InputValidator parser;

    @Before
    public void setUp() throws Exception {
        controller = mock(Controller.class);
        printStream = mock(PrintStream.class);
        board = mock(Board.class);
        parser = mock(InputValidator.class);
        game = new Game(controller, printStream, board, parser);
    }

    @Test
    public void shouldRequestMove() {
        game.play();
        verify(controller).takeMove();
    }

    @Test
    public void shouldInformOfInvalidInput() {
        when(controller.takeMove()).thenReturn("aaa").thenReturn("1");
        when(parser.validate(anyString())).thenReturn(false).thenReturn(true);
        game.play();
        verify(printStream).println("That input is invalid. Please try again.");
    }

    @Test
    public void shouldDrawBoard() {
        game.play();
        verify(board).drawBoard();
    }

    @Test
    public void shouldPerformMoveWhenGivenValidInput() {
        when(controller.takeMove()).thenReturn("2");
        when(parser.validate(anyString())).thenReturn(true);
                game.play();
        verify(board).takeSpace(2);
    }
}
