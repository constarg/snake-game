package com.snake.game;

import com.snake.game.constants.Messages;

import com.snake.game.entities.Snake;
import com.snake.game.environmentalEntities.extend.SnakeFood;
import com.snake.game.inteface.UserInterface;
import com.snake.game.utils.EntityMaker;
import com.snake.game.utils.RefreshGame;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SnakeGameApplication extends Application {
    private Group root;
    private Scene scene;
    private Snake snake;
    private SnakeFood snakeFood;

    private void initializeComponents() {
        this.root = new Group();
    }

    private void configureEntities() {
        this.snake = EntityMaker.makeSnake();
        this.snakeFood = EntityMaker.makeSnakeFood();
    }

    private void configureUserInterface() {
        this.scene = UserInterface.configureScene(this.root, this.snake);
    }

    private void configureStage(Stage stage) {
        stage.setTitle(Messages.GAME_TITLE.message);
        stage.setScene(this.scene);
        stage.setResizable(false);
        stage.show();
        RefreshGame.refreshGame(this.snake, this.snakeFood, this.root);
    }

    @Override
    public void start(Stage stage) throws Exception {
        initializeComponents();
        configureEntities();
        configureUserInterface();
        configureStage(stage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
