package com.snake.game.inteface;

import com.snake.game.constants.ComponentColors;
import com.snake.game.constants.ComponentDimensions;
import com.snake.game.utils.MovementHandler;
import javafx.scene.Group;
import javafx.scene.Scene;

public class UserInterface {

    public static Scene configureScene(Group group) {
        Scene scene = new Scene(
                group,
                ComponentDimensions.MAIN_WINDOW_WIDTH.size,
                ComponentDimensions.MAIN_WINDOW_HEIGHT.size
        );
        scene.setFill(ComponentColors.MAIN_WINDOW_BACKGROUND_COLOR.color);
        scene.setOnKeyPressed(MovementHandler.moveSnake());

        return scene;
    }
}
