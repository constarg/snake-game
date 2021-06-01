package com.snake.game.utils;

import com.snake.game.entities.Snake;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class Keyboard {

    public static EventHandler<KeyEvent> moveSnake(Snake snake) {

        return keyEvent -> {
            switch (keyEvent.getCode()) {
                case UP:
                    Movements.movement(snake, "UP");
                    break;
                case DOWN:
                    Movements.movement(snake, "DOWN");
                    break;
                case LEFT:
                    Movements.movement(snake, "LEFT");
                    break;
                case RIGHT:
                    Movements.movement(snake, "RIGHT");
                    break;
            }
        };

    }
}
