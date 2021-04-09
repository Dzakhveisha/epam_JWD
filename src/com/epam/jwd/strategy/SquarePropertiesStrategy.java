package com.epam.jwd.strategy;

import com.epam.jwd.model.Figure;
import com.epam.jwd.model.Square;

public class SquarePropertiesStrategy implements IFigurePropertiesStrategy {
    @Override
    public double perimeter(Figure figure) {
        Square square = (Square) figure;
        return 4 * size(square);
    }

    @Override
    public double area(Figure figure) {
        Square square = (Square) figure;
        return Math.pow(size(square), 2);
    }

    private double size(Square square) {
        return Math.sqrt(Math.pow(square.getA().getX() - square.getB().getX(), 2) +
                Math.pow(square.getA().getY() - square.getB().getY(), 2));
    }
}
