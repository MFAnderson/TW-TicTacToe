package com.tw.tictactoe;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

/**
 * Created by manderso on 5/1/14.
 */
public class GameTest {

    private Controller controller;
    private Game game;
    private PrintStream printStream;
    private Board board;
    private List<Player> players;
    private Player player1;
    private Player player2;

    @Before
    public void setUp() throws Exception {
        controller = mock(Controller.class);
        printStream = mock(PrintStream.class);
        board = mock(Board.class);
        players = new ArrayList<Player>();
        player1 = mock(Player.class);
        player2 = mock(Player.class);
        players.add(player1);
        players.add(player2);
        when(player1.playerNumber()).thenReturn(1);
        when(player2.playerNumber()).thenReturn(2);
        //say things are fine when we aren't testing behaviour of when they aren't
        when(board.isSpaceOpen(anyInt())).thenReturn(true);
        when(board.isFull()).thenReturn(false).thenReturn(true); //except this, this seems like a code smell
        game = new Game(controller, printStream, board, players);
    }

    @Test
    public void shouldTakeMove() {
        game.play();
        verify(player1).move();
    }

    @Test
    public void shouldDrawBoard() {
        game.play();
        verify(board, atLeastOnce()).drawBoard(); //I feel like this "atLeastOnce" is sketchy
    }

    @Test
    public void shouldRedrawBoardAfterMoveIsTaken() {
        game.play();
        InOrder ordered = inOrder(player1, board);
        ordered.verify(player1).move();
        ordered.verify(board).drawBoard();
    }

    @Test
    public void shouldPromptPlayer2ForMoveAfterPlayer1() {
        when(board.isFull()).thenReturn(false).thenReturn(false).thenReturn(true);
        game.play();
        InOrder order = inOrder(player1, player2);
        order.verify(player1).move();
        order.verify(player2).move();
    }

//    @Test
//    public void shouldNotifyPlayerIfMoveCannotBeMade() {
//        when(board.isSpaceOpen(anyInt())).thenReturn(false).thenReturn(true);
//        game.play();
//        verify(printStream).println("Location already taken");
//    }

    @Test
    public void shouldNotTakeMoreMovesWhenBoardIsFull() {
        when(board.isFull()).thenReturn(true);
        game.play();
        verify(controller, never()).takeMove(1);
    }

}
