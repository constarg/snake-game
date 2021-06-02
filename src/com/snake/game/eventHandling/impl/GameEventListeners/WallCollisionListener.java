package com.snake.game.eventHandling.impl.GameEventListeners;

import com.snake.game.eventHandling.events.GameEvent;
import com.snake.game.entities.Snake;
import com.snake.game.environmentalEntities.extend.SnakeFood;
import com.snake.game.inteface.UserInterface;
import com.snake.game.utils.RefreshGame;

public class WallCollisionListener implements GameEvent {

    @Override
    public void emit(Snake snake) {
        RefreshGame.getGameClock().stop();
        UserInterface.getScene().setOnKeyPressed(null);
    }

    @Override
    public void emit(Snake snake, SnakeFood snakeFood) {}

}
