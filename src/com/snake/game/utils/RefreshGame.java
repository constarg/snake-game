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
    private static Timeline timeline;

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
        // distance = sqrt ( ( x1 - x2 )^2 + ( y1 - y2 )^2 )
        double distance = Tools.calculateDistance(head.getEntityPoint(),
                                                  food.getEntityPoint());

        if (distance <= 10) {
            try {
                manager.eventEmitter(ListenersIdentifiers.EAT_FOOD_LISTENER.eventName, snake, food);
            }
            catch(UnknownListener e) {
                e.printStackTrace();
            }
        }
    }

    private static void snakeTouchTail(Snake snake) {
        TailPiece head = ((LinkedList<TailPiece>) snake.getTailPieces()).getFirst();

        snake.getTailPieces().forEach( tailPiece -> {
            double distance = 15;

            if (!tailPiece.isHead()) {
                distance = Tools.calculateDistance(head.getEntityPoint(),
                                                   tailPiece.getEntityPoint());
            }
            if (Math.ceil(distance) <= 9) {
                try {
                    manager.eventEmitter(ListenersIdentifiers.HEAD_TOUCH_TAIL_LISTENER.eventName, snake, null);
                } catch (UnknownListener unknownListener) {
                    unknownListener.printStackTrace();
                }
            }
        });
    }

    public static Timeline getGameClock() {
        return RefreshGame.timeline;
    }

    public static void refreshGame(Snake snake, SnakeFood food, Group group) {
        group.getChildren().add(food.getEntityShape());

        RefreshGame.timeline = new Timeline(new KeyFrame(Duration.millis(10), t -> {
            RefreshGame.refreshChildren(snake, group);
            RefreshGame.wallCollision(snake);
            RefreshGame.snakeEatFood(snake, food);
            RefreshGame.snakeTouchTail(snake);
        }));

        RefreshGame.timeline.setCycleCount(Timeline.INDEFINITE);
        RefreshGame.timeline.play();
    }
}
