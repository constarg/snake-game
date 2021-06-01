package com.snake.game.constants;

public enum SnakeAcceleration {
    SNAKE_DX(5),
    SNAKE_DY(5);

    public final int d;
    SnakeAcceleration(int d) {
        this.d = d;
    }
}
