package com.snake.game.eventHandling.impl.GameEventListeners;

import com.snake.game.constants.ComponentDimensions;
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
            newPiece = new TailPiece(lastPiece.getEntityPoint(), false);
            snake.getTailPieces().add(newPiece);
        }
    }

    private void changeFoodPoint(SnakeFood snakeFood) {
        int newX = getRandomCoordinate(ComponentDimensions.MAIN_WINDOW_WIDTH.size,100);
        int newY = getRandomCoordinate(ComponentDimensions.TAIL_PIECE_HEIGHT.size, 100);

        Point newPoint = new Point(newX, newY);
        snakeFood.getEntityShape().setX(newPoint.getX());
        snakeFood.getEntityShape().setY(newPoint.getY());
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
