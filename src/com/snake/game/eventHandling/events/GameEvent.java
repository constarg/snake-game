package com.snake.game.eventHandling.events;

import com.snake.game.entities.Snake;
import com.snake.game.environmentalEntities.extend.SnakeFood;

public interface GameEvent {
    void emit(Snake snake);
    void emit(Snake snake, SnakeFood snakeFood);
}
