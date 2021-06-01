package com.snake.game.environmentalEntities;

import javafx.scene.shape.Rectangle;

import java.awt.Point;
import java.awt.Dimension;

public abstract class EnvironmentalEntityDetails {
    protected Dimension entityDimension;
    protected Point entityPoint;
    protected Rectangle entityShape;

    public Dimension getEntityDimension() {
        return this.entityDimension;
    }

    public Point getEntityPoint() {
        return this.entityPoint;
    }

    public Rectangle getEntityShape() { return this.entityShape; }

    public void setEntityPoint(Point newPoint) { this.entityPoint = newPoint; }
}
