package com.tw.tictactoe;

/**
 * Created by manderso on 5/1/14.
 */
public class Game {
    private Controller controller;

    public Game(Controller controller) {

        this.controller = controller;
    }

    public void play() {
        controller.takeMove();
    }
}
