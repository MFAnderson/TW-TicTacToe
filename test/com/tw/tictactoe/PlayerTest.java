package com.tw.tictactoe;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PlayerTest {

    private Player player;
    private Board board;
    private Controller controller;

    @Before
    public void setUp() throws Exception {
        board = mock(Board.class);
        controller = mock(Controller.class);
        player = new Player(1, 'X', board, controller);
        when(board.isSpaceOpen(anyInt())).thenReturn(true);
    }

    @Test
    public void shouldRequestInput() {
        player.move();
        verify(controller).takeMove(1);
    }

    @Test
    public void shouldMarkBoardAt0IndexedSpace() {
        when(controller.takeMove(1)).thenReturn(1);
        player.move();
        verify(board).markSpace(0, 'X');
    }


}