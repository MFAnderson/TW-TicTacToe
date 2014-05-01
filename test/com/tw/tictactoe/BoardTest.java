package com.tw.tictactoe;



import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by manderso on 5/1/14.
 */
public class BoardTest {

    private PrintStream printStream;
    private Board board;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        board = new Board(printStream);
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
}
