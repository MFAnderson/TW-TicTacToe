package com.tw.tictactoe;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by manderso on 5/1/14.
 */
public class GameTest {

    @Test
    public void shouldRequestMove() {
        Controller controller = mock(Controller.class);
        Game game = new Game(controller);
        game.play();
        verify(controller).takeMove();
    }
}
