package com.snake.game.utils;

import com.snake.game.constants.ComponentDimensions;
import com.snake.game.constants.ListenersIdentifiers;
import com.snake.game.entities.Snake;
import com.snake.game.environmentalEntities.extend.SnakeFood;
import com.snake.game.environmentalEntities.extend.TailPiece;
import com.snake.game.eventHandling.managers.GameEventManager.GameEventManager;
import com.snake.game.exceptions.UnknownListener;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.util.LinkedList;

public class RefreshGame {
    private static final GameEventManager manager = new GameEventManager();

    private static void refreshChildren(Snake snake, Group group) {
        snake.getTailPieces().forEach(tailPiece -> {
            Rectangle tailShape = tailPiece.getEntityShape();

            if (!group.getChildren().contains(tailShape)) {
                group.getChildren().add(tailShape);
            }
        });
    }

    private static void wallCollision(Snake snake) {
        TailPiece head = ((LinkedList<TailPiece>) snake.getTailPieces()).getFirst();

        if (head.getEntityShape().getX() + head.getEntityShape().getWidth() >= ComponentDimensions.MAIN_WINDOW_WIDTH.size
            || head.getEntityShape().getX() - head.getEntityShape().getWidth() <= 0
            || head.getEntityShape().getY() + head.getEntityShape().getWidth() >= ComponentDimensions.MAIN_WINDOW_HEIGHT.size
            || head.getEntityShape().getY() - head.getEntityShape().getWidth() <= 0) {

            try {
                manager.eventEmitter(ListenersIdentifiers.WALL_COLLISION_LISTENER.eventName, snake,null);
            }
            catch(UnknownListener e) {
                e.printStackTrace();
            }


        }
    }

    private static void snakeEatFood(Snake snake, SnakeFood food) {
        TailPiece head = ((LinkedList<TailPiece>) snake.getTailPieces()).getFirst();
        double x = head.getEntityShape().getX() - food.getEntityShape().getX();
        double y = head.getEntityShape().getY() - food.getEntityShape().getY();
        double distance = Math.abs(Math.sqrt(x + y));

        if (distance < 4) {
            try {
                manager.eventEmitter(ListenersIdentifiers.EAT_FOOD_LISTENER.eventName, snake, food);
            }
            catch(UnknownListener e) {
                e.printStackTrace();
            }

        }
    }

    private static void snakeTouchHead(Snake snake) {

    }

    public static void refreshGame(Snake snake, SnakeFood food, Group group) {
        group.getChildren().add(food.getEntityShape());

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(20), t -> {
            RefreshGame.refreshChildren(snake, group);
            RefreshGame.wallCollision(snake);
            RefreshGame.snakeEatFood(snake, food);
        }));

        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }
}
