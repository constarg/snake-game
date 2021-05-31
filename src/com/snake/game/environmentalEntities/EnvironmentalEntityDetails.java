package com.snake.game.environmentalEntities;

import java.awt.Point;
import java.awt.Dimension;

public abstract class EnvironmentalEntityDetails {
    protected Dimension entityDimension;
    protected Point entityPoint;

    public Dimension getEntityDimension() {
        return this.entityDimension;
    }

    public Point getEntityPoint() {
        return this.entityPoint;
    }

    public void setEntityPoint(Point newPoint) {
        this.entityPoint = newPoint;
    }
}
