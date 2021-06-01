package com.snake.game.utils;

import com.snake.game.constants.SnakeAcceleration;
import com.snake.game.entities.Snake;

import java.awt.Point;

public class Movements {

    private static Point calculateMovement(Point point, String direction, boolean isPrevious) {
        int newX = 0;
        int newY = 0;

        switch (direction) {
            case "UP":
                newX = point.x;
                newY = (isPrevious)? point.y + SnakeAcceleration.SNAKE_DY.d : point.y - SnakeAcceleration.SNAKE_DY.d;
                break;
            case "DOWN":
                newX = point.x;
                newY = (isPrevious)? point.y - SnakeAcceleration.SNAKE_DY.d : point.y + SnakeAcceleration.SNAKE_DY.d;
                break;
            case "LEFT":
                newX = (isPrevious)? point.x + SnakeAcceleration.SNAKE_DX.d : point.x - SnakeAcceleration.SNAKE_DX.d;
                newY = point.y;
                break;
            case "RIGHT":
                newX = (isPrevious)? point.x - SnakeAcceleration.SNAKE_DX.d : point.x + SnakeAcceleration.SNAKE_DX.d;
                newY = point.y;
                break;
        }

        return new Point(newX, newY);
    }

    public static void movement(Snake snake, String direction) {
        snake.getTailPieces().forEach( tailPiece -> {
            Point newPoint;

            if (!tailPiece.isHead()) {
                Point prevTailPoint = tailPiece.getPreviousTailPoint();
                newPoint = Movements.calculateMovement(prevTailPoint, direction, true);
            }
            else {
                System.out.println("head");
                Point currTailPoint = tailPiece.getEntityPoint();
                newPoint = Movements.calculateMovement(currTailPoint, direction, false);
            }
            tailPiece.getEntityShape().setX(newPoint.getX());
            tailPiece.getEntityShape().setY(newPoint.getY());
            tailPiece.setEntityPoint(newPoint);
        });
    }
}
