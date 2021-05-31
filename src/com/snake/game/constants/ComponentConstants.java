package com.snake.game.constants;

public enum ComponentConstants {

    SPACE_BETWEEN_TAIL_PIECES(5),

    SNAKE_START_X(500),
    SNAKE_START_Y(300);

    public final int constant;
    ComponentConstants(int constant) {
        this.constant = constant;
    }
}
