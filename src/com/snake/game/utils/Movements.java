package com.snake.game.utils;

import com.snake.game.constants.SnakeAcceleration;
import com.snake.game.entities.Snake;
import com.snake.game.environmentalEntities.extend.TailPiece;

import java.awt.Point;
import java.util.LinkedList;

public class Movements {
    private static String currentDirection = "RIGHT";

    private static Point calculateMovement(Point point, String direction) {
        int newX = 0;
        int newY = 0;

        switch (direction) {
            case "UP":
                newX = point.x;
                newY = point.y - SnakeAcceleration.SNAKE_DY.d;
                break;
            case "DOWN":
                newX = point.x;
                newY = point.y + SnakeAcceleration.SNAKE_DY.d;
                break;
            case "LEFT":
                newX = point.x - SnakeAcceleration.SNAKE_DX.d;
                newY = point.y;
                break;
            case "RIGHT":
                newX = point.x + SnakeAcceleration.SNAKE_DX.d;
                newY = point.y;
                break;
        }

        return new Point(newX, newY);
    }

    public static void setCurrentDirection(String newDirection) {
        Movements.currentDirection = newDirection;
    }

    public static void movement(Snake snake) {
        snake.getTailPieces().forEach( tailPiece -> {
            Point newPoint;
            if (!tailPiece.isHead()) {
                TailPiece prevTail = Tools.getTailFromIndex((LinkedList<TailPiece>)snake.getTailPieces(), tailPiece.getTailIndex()-1);
                newPoint = prevTail.getPreviousPoint();
            }
            else {
                Point currTailPoint = tailPiece.getEntityPoint();
                newPoint = Movements.calculateMovement(currTailPoint, currentDirection);
            }
            tailPiece.getEntityShape().setX(newPoint.getX());
            tailPiece.getEntityShape().setY(newPoint.getY());
            tailPiece.setPreviousPoint(tailPiece.getEntityPoint());
            tailPiece.setEntityPoint(newPoint);
        });
    }
}
