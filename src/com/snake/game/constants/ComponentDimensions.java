package com.snake.game.constants;

public enum ComponentDimensions {
    TAIL_PIECE_WIDTH(30),
    TAIL_PIECE_HEIGHT(30),
    FOOD_WIDTH(20),
    FOOD_HEIGHT(20),
    MAIN_WINDOW_WIDTH(1200),
    MAIN_WINDOW_HEIGHT(800);

    public final int size;
    ComponentDimensions(int size) {
        this.size = size;
    }
}
