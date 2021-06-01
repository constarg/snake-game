package com.snake.game.utils;

import com.snake.game.constants.ComponentConstants;
import com.snake.game.entities.Snake;
import com.snake.game.environmentalEntities.extend.SnakeFood;

import java.awt.Point;

public class EntityMaker {

    public static Snake makeSnake() {
        return new Snake();
    }

    public static SnakeFood makeSnakeFood() {
        return new SnakeFood(new Point(
                ComponentConstants.SNAKE_FOOD_START_X.constant,
                ComponentConstants.SNAKE_FOOD_START_Y.constant
        ));
    }
}
