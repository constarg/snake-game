package com.snake.game.environmentalEntities.extend;

import com.snake.game.constants.ComponentConstants;
import com.snake.game.constants.ComponentDimensions;
import com.snake.game.environmentalEntities.EnvironmentalEntityDetails;

import java.awt.Point;
import java.awt.Dimension;

public class TailPiece extends EnvironmentalEntityDetails {

    private static int pieceIndex = 0;
    private final int delay;

    public TailPiece(Point previousPoint, Integer delay) {
        this.entityPoint = new Point(previousPoint.x + ComponentConstants.SPACE_BETWEEN_TAIL_PIECES.constant, previousPoint.y + ComponentConstants.SPACE_BETWEEN_TAIL_PIECES.constant);
        this.entityDimension = new Dimension(ComponentDimensions.TAIL_PIECE_WIDTH.size, ComponentDimensions.TAIL_PIECE_HEIGHT.size);
        this.delay = delay;
        TailPiece.pieceIndex++;
    }

    public int getDelay() {
        return this.delay;
    }
}
