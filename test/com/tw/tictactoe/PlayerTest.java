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
    private InputManager inputManager;

    @Before
    public void setUp() throws Exception {
        board = mock(Board.class);
        inputManager = mock(InputManager.class);
        player = new Player(1, 'X', board, inputManager);
        when(board.isSpaceOpen(anyInt())).thenReturn(true);
    }

    @Test
    public void shouldRequestInput() {
        player.move();
        verify(inputManager).takeMove(1);
    }

    @Test
    public void shouldMarkBoardAtCorrectSpace() {
        when(inputManager.takeMove(1)).thenReturn(1);
        player.move();
        verify(board).markSpace(1, 'X');
    }


}