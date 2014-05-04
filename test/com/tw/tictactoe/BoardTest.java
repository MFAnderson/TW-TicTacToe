package com.tw.tictactoe;



import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by manderso on 5/1/14.
 */
public class BoardTest {

    private PrintStream printStream;
    private Board board;
    private char[] boardSpaces;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        boardSpaces = new char[9];
        board = new Board(printStream, boardSpaces);

    }

    @Test
    public void shouldDrawABoard() {

        board.drawBoard();
        verify(printStream).println(
                    " | | " + "\n"
                +   "-----" + "\n"
                +   " | | " + "\n"
                +   "-----" + "\n"
                +   " | | "
        );
    }

    @Test
    public void shouldAcceptAValidMove() {
        board.takeSpace(1, Player.ONE);
        assertThat(boardSpaces[0], is('X'));
    }

    @Test
    public void shouldDrawXInSpaceOccupiedByPlayerOne() {
        boardSpaces[0] = 'X';
        board.drawBoard();
        verify(printStream).println(
                            "X| | " + "\n"
                        +   "-----" + "\n"
                        +   " | | " + "\n"
                        +   "-----" + "\n"
                        +   " | | "
        );
    }

    @Test
    public void shouldTrackSpaceSelectedByPlayer2() {
        board.takeSpace(1, Player.TWO);
        assertThat(boardSpaces[0], is('O'));
    }

    @Test
    public void shouldNotOverwriteOccupiedSpace() {
        board.takeSpace(1, Player.ONE);
        board.takeSpace(1, Player.TWO);
        assertThat(boardSpaces[0], is('X'));
    }

    @Test
    public void shouldIndicateSpaceIsFull() {
        board.takeSpace(1, Player.ONE);
        assertThat(board.isSpaceOpen(1), is(false));
    }

    @Test
    public void shouldIndicatedWhenNoMovesLeft() {
        Arrays.fill(boardSpaces, 'X');
        assertThat(board.isFull(), is(true));
    }

    @Test
    public void shouldNotIndicateFullnessWhenSpacesRemain() {
        assertThat(board.isFull(), is(false));
    }

    @Test
    public void shouldDetectWinnerAlongHorizontal() {
        boardSpaces[0] = 'X';
        boardSpaces[1] = 'X';
        boardSpaces[2] = 'X';
        assertThat(board.findWinner(), is('X'));
    }

    @Test
    public void shouldDetectWinnerAlongVertical() {
        boardSpaces[0] = 'O';
        boardSpaces[3] = 'O';
        boardSpaces[6] = 'O';
        assertThat(board.findWinner(), is('O'));
    }

    @Test
    public void shouldDetectWinnerAlongDiagonal() {
        boardSpaces[0] = 'X';
        boardSpaces[4] = 'X';
        boardSpaces[8] = 'X';
        assertThat(board.findWinner(), is('X'));
    }
}
