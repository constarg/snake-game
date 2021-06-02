package com.snake.game.inteface;

import com.snake.game.constants.ComponentColors;
import com.snake.game.constants.ComponentDimensions;
import com.snake.game.entities.Snake;
import com.snake.game.utils.Keyboard;
import javafx.scene.Group;
import javafx.scene.Scene;

public class UserInterface {
    private static Scene scene;

    public static Scene configureScene(Group group, Snake snake) {
        UserInterface.scene = new Scene(
                group,
                ComponentDimensions.MAIN_WINDOW_WIDTH.size,
                ComponentDimensions.MAIN_WINDOW_HEIGHT.size
        );
        scene.setFill(ComponentColors.MAIN_WINDOW_BACKGROUND_COLOR.color);
        scene.setOnKeyPressed(Keyboard.moveSnake(snake));

        return scene;
    }

    public static Scene getScene() {
        return UserInterface.scene;
    }
}
