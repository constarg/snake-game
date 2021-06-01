package com.snake.game.utils;

import com.snake.game.constants.SnakeAcceleration;
import com.snake.game.entities.Snake;

import java.awt.Point;

public class Movements {

    private static Point calculateMovement(Point point, String direction) {
        int newX = 0;
        int newY = 0;

        switch (direction) {
            case "UP":
                newX = point.x;
                newY = point.y + SnakeAcceleration.SNAKE_DY.d;
                break;
            case "DOWN":
                newX = point.x;
                newY = point.y - SnakeAcceleration.SNAKE_DY.d;
                break;
            case "LEFT":
                newX = point.x + SnakeAcceleration.SNAKE_DX.d;
                newY = point.y;
                break;
            case "RIGHT":
                newX = point.x - SnakeAcceleration.SNAKE_DX.d;
                newY = point.y;
                break;
        }

        return new Point(
                newX,
                newY
        );
    }

    public static void movement(Snake snake, String direction) {
        snake.getTailPieces().forEach( tailPiece -> {
            Point newPoint;

            if (tailPiece.getPreviousTailPoint() != null) {
                Point prevTailPoint = tailPiece.getPreviousTailPoint();
                newPoint = Movements.calculateMovement(prevTailPoint, direction);
            }
            else {
                Point currTailPoint = tailPiece.getEntityPoint();
                newPoint = Movements.calculateMovement(currTailPoint, direction);
            }
            tailPiece.setEntityPoint(newPoint);
        });
    }
}
