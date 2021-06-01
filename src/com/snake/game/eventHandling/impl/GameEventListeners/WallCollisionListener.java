package com.snake.game.eventHandling.impl.GameEventListeners;

import com.snake.game.eventHandling.events.GameEvent;
import com.snake.game.entities.Snake;
import com.snake.game.environmentalEntities.extend.SnakeFood;

public class WallCollisionListener implements GameEvent {

    @Override
    public void emit(Snake snake) {
        // toDO make something to end the game.
    }

    @Override
    public void emit(Snake snake, SnakeFood snakeFood) {}


}
