package com.snake.game.environmentalEntities.extend;

import com.snake.game.constants.ComponentColors;
import com.snake.game.constants.ComponentConstants;
import com.snake.game.constants.ComponentDimensions;
import com.snake.game.environmentalEntities.EnvironmentalEntityDetails;
import javafx.scene.shape.Rectangle;

import java.awt.Point;
import java.awt.Dimension;

public class TailPiece extends EnvironmentalEntityDetails {

    private static int pieceIndex = 0;
    private final Point previousTailPoint;
    private boolean head;

    public TailPiece(Point previousTailPoint, boolean head) {
        this.entityPoint = new Point(previousTailPoint.x + ComponentConstants.SPACE_BETWEEN_TAIL_PIECES.constant, previousTailPoint.y + ComponentConstants.SPACE_BETWEEN_TAIL_PIECES.constant);
        this.entityDimension = new Dimension(ComponentDimensions.TAIL_PIECE_WIDTH.size, ComponentDimensions.TAIL_PIECE_HEIGHT.size);
        this.entityShape = new Rectangle(entityDimension.width, entityDimension.height);
        this.entityShape.setX(entityPoint.getX());
        this.entityShape.setY(entityPoint.getY());
        this.entityShape.setFill(ComponentColors.TAIL_COLOR.color);
        this.previousTailPoint = previousTailPoint;
        this.head = head;
        TailPiece.pieceIndex++;
    }

    public Point getPreviousTailPoint() {
        return this.previousTailPoint;
    }

    public boolean isHead() {
        return this.head;
    }
}
