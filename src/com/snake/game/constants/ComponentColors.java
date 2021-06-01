package com.snake.game.constants;

import javafx.scene.paint.Color;

public enum ComponentColors {
    MAIN_WINDOW_BACKGROUND_COLOR(Color.BLACK),
    TAIL_COLOR(Color.WHITE),
    FOOD_COLOR(Color.RED);


    public final Color color;
    ComponentColors(Color color) {
        this.color = color;
    }
}
