package com.snake.game.constants;

public enum ComponentDimensions {
    TAIL_PIECE_WIDTH(50),
    TAIL_PIECE_HEIGHT(50),
    FOOD_WIDTH(30),
    FOOD_HEIGHT(50),
    MAIN_WINDOW_WIDTH(500),
    MAIN_WINDOW_HEIGHT(500);

    public final int size;
    ComponentDimensions(int size) {
        this.size = size;
    }
}
