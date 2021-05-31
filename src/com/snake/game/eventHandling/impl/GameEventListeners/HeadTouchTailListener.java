package com.snake.game.eventHandling.impl.GameEventListeners;

import com.snake.game.eventHandling.events.GameEvent;
import com.snake.game.entities.Snake;
import com.snake.game.environmentalEntities.extend.SnakeFood;

public class HeadTouchTailListener implements GameEvent {

    @Override
    public void emit(Snake snake) {
        // call the game over.
    }

    @Override
    public void emit(Snake snake, SnakeFood snakeFood) {}

}
