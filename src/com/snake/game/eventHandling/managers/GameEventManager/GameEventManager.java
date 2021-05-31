package com.snake.game.eventHandling.managers.GameEventManager;

import com.snake.game.eventHandling.events.GameEvent;
import com.snake.game.eventHandling.impl.GameEventListeners.EatFoodListener;
import com.snake.game.eventHandling.impl.GameEventListeners.HeadTouchTailListener;
import com.snake.game.eventHandling.impl.GameEventListeners.WallCollisionListener;
import com.snake.game.exceptions.UnknownListener;
import com.snake.game.entities.Snake;
import com.snake.game.environmentalEntities.extend.SnakeFood;

import java.text.MessageFormat;
import java.util.HashMap;

public class GameEventManager {

    private final HashMap<String, GameEvent> gameEventListeners;

    public GameEventManager() {
        gameEventListeners = new HashMap<>();
        // listeners.
        gameEventListeners.put("eat-food-listener", new EatFoodListener());
        gameEventListeners.put("head-touch-tail-listener", new HeadTouchTailListener());
        gameEventListeners.put("wall-collision-listener", new WallCollisionListener());
    }

    public void eventEmitter(String event, Snake snake, SnakeFood snakeFood) throws UnknownListener {
        GameEvent listener = gameEventListeners.get(event);

        if (listener == null) throw new UnknownListener(
                MessageFormat.format("The event ", event, " does not exists")
        );

        if (snakeFood == null) listener.emit(snake);
        else listener.emit(snake, snakeFood);

    }
}
