package com.snake.game.environmentalEntities.extend;

import com.snake.game.constants.ComponentDimensions;
import com.snake.game.environmentalEntities.EnvironmentalEntityDetails;

import java.awt.Dimension;
import java.awt.Point;

public class SnakeFood extends EnvironmentalEntityDetails {

    public SnakeFood(Point initialPoint) {
        this.entityPoint = initialPoint;
        this.entityDimension = new Dimension(ComponentDimensions.FOOD_WIDTH.size, ComponentDimensions.FOOD_HEIGHT.size);
    }
}
