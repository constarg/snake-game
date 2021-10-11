package com.snake.game.utils;

import com.snake.game.entities.Snake;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class Keyboard {

    public static EventHandler<KeyEvent> moveSnake(Snake snake) {

        return keyEvent -> {
            switch (keyEvent.getCode()) {
                case UP:
                    Movements.setCurrentDirection("UP");
                    break;
                case DOWN:
                    Movements.setCurrentDirection("DOWN");
                    break;
                case LEFT:
                    Movements.setCurrentDirection("LEFT");
                    break;
                case RIGHT:
                    Movements.setCurrentDirection("RIGHT");
                    break;
            }
        };

    }
}
