package com.snake.game.constants;

public enum ListenersIdentifiers {
    // listeners identifiers.
    EAT_FOOD_LISTENER("eat-food-listener"),
    HEAD_TOUCH_TAIL_LISTENER("head-touch-tail-listener"),
    WALL_COLLISION_LISTENER("wall-collision-listener");


    public final String eventName;
    ListenersIdentifiers(String eventName) {
        this.eventName = eventName;
    }
}
