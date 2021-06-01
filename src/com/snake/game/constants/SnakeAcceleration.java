package com.snake.game.constants;

public enum SnakeAcceleration {
    SNAKE_DX(8),
    SNAKE_DY(8);

    public final int d;
    SnakeAcceleration(int d) {
        this.d = d;
    }
}
