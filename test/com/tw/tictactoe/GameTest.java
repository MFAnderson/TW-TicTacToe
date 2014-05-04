package com.tw.tictactoe;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

import java.io.PrintStream;

import static org.mockito.Mockito.*;

/**
 * Created by manderso on 5/1/14.
 */
public class GameTest {

    private Controller controller;
    private Game game;
    private PrintStream printStream;
    private Board board;
    private InputValidator validator;
    private InputParser parser;

    @Before
    public void setUp() throws Exception {
        controller = mock(Controller.class);
        printStream = mock(PrintStream.class);
        board = mock(Board.class);
        validator = mock(InputValidator.class);
        parser = mock(InputParser.class);
        //say things are fine when we aren't testing behaviour of when they aren't
        when(validator.validate(anyString())).thenReturn(true);
        when(board.takeSpace(anyInt(), any(Player.class))).thenReturn(true);
        when(board.isFull()).thenReturn(false).thenReturn(true); //except this, this seems like a code smell
        game = new Game(controller, printStream, board, validator, parser);
    }

    @Test
    public void shouldRequestMove() {
        game.play();
        verify(controller).takeMove(Player.ONE);
    }

    @Test
    public void shouldDrawBoard() {
        game.play();
        verify(board, atLeastOnce()).drawBoard(); //I feel like this "atLeastOnce" is sketchy
    }

    @Test
    public void shouldPerformGivenMove() {
        when(controller.takeMove(Player.ONE)).thenReturn(2);
        game.play();
        verify(board).takeSpace(2, Player.ONE);
    }

    @Test
    public void shouldRedrawBoardAfterMoveIsTaken() {
        game.play();
        InOrder ordered = inOrder(controller, board);
        ordered.verify(controller).takeMove(any(Player.class));
        ordered.verify(board).drawBoard();
    }

    @Test
    public void shouldPromptPlayer2ForMoveAfterPlayer1() {
        when(board.isFull()).thenReturn(false).thenReturn(false).thenReturn(true);
        game.play();
        InOrder order = inOrder(controller);
        order.verify(controller).takeMove(Player.ONE);
        order.verify(controller).takeMove(Player.TWO);
    }

    @Test
    public void shouldNotifyPlayerIfMoveCannotBeMade() {
        when(board.takeSpace(anyInt(), any(Player.class))).thenReturn(false).thenReturn(true);
        game.play();
        verify(printStream).println("Location already taken");
    }

    @Test
    public void shouldNotTakeMoreMovesWhenBoardIsFull() {
        when(board.isFull()).thenReturn(true);
        game.play();
        verify(controller, never()).takeMove(any(Player.class));
    }

}
