package com.snake.game.constants;

public enum ComponentConstants {

    SPACE_BETWEEN_TAIL_PIECES(5),

    SNAKE_START_X(500),
    SNAKE_START_Y(700),

    SNAKE_FOOD_START_X(300),
    SNAKE_FOOD_START_Y(300);

    public final int constant;
    ComponentConstants(int constant) {
        this.constant = constant;
    }
}
