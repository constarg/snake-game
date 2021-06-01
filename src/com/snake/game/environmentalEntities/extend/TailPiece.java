package com.snake.game.environmentalEntities.extend;

import com.snake.game.constants.ComponentConstants;
import com.snake.game.constants.ComponentDimensions;
import com.snake.game.environmentalEntities.EnvironmentalEntityDetails;

import java.awt.Point;
import java.awt.Dimension;

public class TailPiece extends EnvironmentalEntityDetails {

    private static int pieceIndex = 0;
    private final Point previousTailPoint;

    public TailPiece(Point previousTailPoint) {
        this.entityPoint = new Point(previousTailPoint.x + ComponentConstants.SPACE_BETWEEN_TAIL_PIECES.constant, previousTailPoint.y + ComponentConstants.SPACE_BETWEEN_TAIL_PIECES.constant);
        this.entityDimension = new Dimension(ComponentDimensions.TAIL_PIECE_WIDTH.size, ComponentDimensions.TAIL_PIECE_HEIGHT.size);
        this.previousTailPoint = previousTailPoint;
        TailPiece.pieceIndex++;
    }

    public Point getPreviousTailPoint() {
        return this.previousTailPoint;
    }
}
