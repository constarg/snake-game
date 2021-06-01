package com.snake.game.environmentalEntities.extend;

import com.snake.game.constants.ComponentColors;
import com.snake.game.constants.ComponentDimensions;
import com.snake.game.environmentalEntities.EnvironmentalEntityDetails;
import javafx.scene.shape.Rectangle;

import java.awt.Dimension;
import java.awt.Point;

public class SnakeFood extends EnvironmentalEntityDetails {

    public SnakeFood(Point initialPoint) {
        this.entityPoint = initialPoint;
        this.entityDimension = new Dimension(ComponentDimensions.FOOD_WIDTH.size, ComponentDimensions.FOOD_HEIGHT.size);
        this.entityShape = new Rectangle(entityDimension.width, entityDimension.height);
        this.entityShape.setX(entityPoint.getX());
        this.entityShape.setY(entityPoint.getY());
        this.entityShape.setFill(ComponentColors.FOOD_COLOR.color);
    }
}
