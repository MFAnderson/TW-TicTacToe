package com.tw.tictactoe;



import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

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
    private Player[][] boardSpaces;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        boardSpaces = new Player[3][3];
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
        assertThat(boardSpaces[0][0], is(Player.ONE));
    }

    @Test
    public void shouldDrawXInOccupiedSpace() {
        boardSpaces[0][0] = Player.ONE;
        boardSpaces[2][1] = Player.ONE;
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
        assertThat(boardSpaces[0][0], is(Player.TWO));
    }
}
