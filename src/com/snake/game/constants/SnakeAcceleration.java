package com.snake.game.constants;

public enum SnakeAcceleration {
    SNAKE_DX(15),
    SNAKE_DY(15);

    public final int d;
    SnakeAcceleration(int d) {
        this.d = d;
    }
}
