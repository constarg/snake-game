package com.snake.game.utils;

import com.snake.game.environmentalEntities.extend.TailPiece;

import java.awt.*;
import java.util.LinkedList;

public class Tools {

    public static TailPiece getTailFromIndex(LinkedList<TailPiece> pieces, int index) {
        return pieces.get(index);
    }

    public static double calculateDistance(Point point1, Point point2) {
        return Math.sqrt(Math.pow((point1.x-point2.x),2) + Math.pow((point1.y-point2.y),2));
    }
}
