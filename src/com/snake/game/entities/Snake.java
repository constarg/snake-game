package com.snake.game.entities;

import com.snake.game.constants.ComponentConstants;
import com.snake.game.environmentalEntities.extend.TailPiece;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;


public class Snake {

    private final Queue<TailPiece> tailPieces;

    public Snake() {
        this.tailPieces = new LinkedList<>();
        // Head.
        this.tailPieces.add(new TailPiece(new Point(ComponentConstants.SNAKE_START_X.constant, ComponentConstants.SNAKE_START_Y.constant), 0));
    }

    public Queue<TailPiece> getTailPieces() {
        return this.tailPieces;
    }

}
