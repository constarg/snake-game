package com.snake.game.constants;

public enum ComponentDimensions {
    TAIL_PIECE_WIDTH(50),
    TAIL_PIECE_HEIGHT(50);

    public final int size;
    ComponentDimensions(int size) {
        this.size = size;
    }
}
