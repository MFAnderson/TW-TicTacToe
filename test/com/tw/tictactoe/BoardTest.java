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
    private boolean[][] boardSpaces;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        boardSpaces = new boolean[3][3];
        board = new Board(printStream, boardSpaces);
    }

    @Test
    public void shouldDrawABoard() {

        board.displayBoard();
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
        board.takeSpace(1);
        assertThat(boardSpaces[0][0], is(true));
    }


}
