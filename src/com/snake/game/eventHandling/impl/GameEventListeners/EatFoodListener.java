package com.snake.game.eventHandling.impl.GameEventListeners;

import com.snake.game.eventHandling.events.GameEvent;
import com.snake.game.entities.Snake;
import com.snake.game.environmentalEntities.extend.SnakeFood;
import com.snake.game.environmentalEntities.extend.TailPiece;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Random;

public class EatFoodListener implements GameEvent {
    private final Random random;

    public EatFoodListener() {
        random = new Random();
    }

    @Override
    public void emit(Snake snake) {}

    @Override
    public void emit(Snake snake, SnakeFood snakeFood) {
        longerTheTail(snake);
        changeFoodPoint(snakeFood);
    }

    private void longerTheTail(Snake snake) {
        TailPiece lastPiece = ((LinkedList<TailPiece>) snake.getTailPieces()).getLast();
        TailPiece newPiece;

        if (lastPiece != null) {
            newPiece = new TailPiece(lastPiece.getEntityPoint());
            snake.getTailPieces().add(newPiece);
        }
    }

    private void changeFoodPoint(SnakeFood snakeFood) {
        int newX = getRandomCoordinate(5,1);
        int newY = getRandomCoordinate(10,2);
        // toDO fill the above parameters with the width and height of the scene.
        // toDO for the x fill it with the width of the scene and etc for the y.

        Point newPoint = new Point(newX, newY);
        snakeFood.setEntityPoint(newPoint);
    }

    /**
     * @param max
     * @param min
     * @referance https://stackoverflow.com/questions/363681/how-do-i-generate-random-integers-within-a-specific-range-in-java
     * @return the random value.
     */
    private int getRandomCoordinate(int max, int min) {
        return random.nextInt( (max - min) + 1) + min;
    }
}
