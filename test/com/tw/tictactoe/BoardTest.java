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
    private Player[] boardSpaces;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        boardSpaces = new Player[9];
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
        assertThat(boardSpaces[0], is(Player.ONE));
    }

    @Test
    public void shouldDrawXInSpaceOccupiedByPlayerOne() {
        boardSpaces[0] = Player.ONE;
        boardSpaces[7] = Player.ONE;
        board.drawBoard();
        verify(printStream).println(
                            "X| | " + "\n"
                        +   "-----" + "\n"
                        +   " | | " + "\n"
                        +   "-----" + "\n"
                        +   " |X| "
        );
    }

    @Test
    public void shouldTrackSpaceSelectedByPlayer2() {
        board.takeSpace(1, Player.TWO);
        assertThat(boardSpaces[0], is(Player.TWO));
    }

    @Test
    public void shouldDrawOInSpaceOccupiedByPlayerTwo() {
        boardSpaces[4] = Player.TWO;
        board.drawBoard();
        verify(printStream).println(
                            " | | " + "\n"
                        +   "-----" + "\n"
                        +   " |O| " + "\n"
                        +   "-----" + "\n"
                        +   " | | "
        );
    }

    @Test
    public void shouldNotOverwriteOccupiedSpace() {
        board.takeSpace(1, Player.ONE);
        board.takeSpace(1, Player.TWO);
        assertThat(boardSpaces[0], is(Player.ONE));
    }

    @Test
    public void shouldIndicateFailureIfSpaceNotTaken() {
        board.takeSpace(1, Player.ONE);
        assertThat(board.takeSpace(1, Player.TWO), is(false));
    }

    @Test
    public void shouldIndicatedWhenNoMovesLeft() {
        Arrays.fill(boardSpaces, Player.ONE);
        assertThat(board.isFull(), is(true));
    }

    @Test
    public void shouldNotIndicateFullnessWhenSpacesRemain() {
        assertThat(board.isFull(), is(false));
    }


}
