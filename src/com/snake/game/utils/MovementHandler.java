package com.snake.game.utils;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class MovementHandler {

    public static EventHandler<KeyEvent> moveSnake() {

        return keyEvent -> {
            // toDO end the movements.
            switch (keyEvent.getCode()) {
                case UP:
                    // move up.
                    break;
                case DOWN:
                    // move down.
                    break;
                case LEFT:
                    // move left.
                    break;
                case RIGHT:
                    // move right.
                    break;
            }
        };

    }
}
