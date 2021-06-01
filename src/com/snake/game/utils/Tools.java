package com.snake.game.utils;

import com.snake.game.environmentalEntities.extend.TailPiece;

import java.util.LinkedList;

public class Tools {

    public static TailPiece getTailFromIndex(LinkedList<TailPiece> pieces, int index) {
        return pieces.get(index);
    }

    public static double calculateDistance(double x1, double x2, double y1, double y2) {
        return Math.sqrt(Math.pow((x1-x2),2) + Math.pow((y1-y2),2));
    }
}
