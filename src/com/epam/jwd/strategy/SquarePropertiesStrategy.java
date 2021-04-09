package com.epam.jwd.strategy;

import com.epam.jwd.model.Square;

public class SquarePropertiesStrategy implements FigurePropertiesStrategy<Square> {

    private static SquarePropertiesStrategy instance = null;

    private SquarePropertiesStrategy() {}

    public static SquarePropertiesStrategy getInstance() {    // lazy singleton
        if (instance == null) {
            synchronized(SquarePropertiesStrategy.class) {
                if (instance == null) {
                    instance = new SquarePropertiesStrategy();
                }
            }
        }
        return instance;
    }


    @Override
    public double perimeter(Square figure) {
        Square square = (Square) figure;
        return 4 * size(square);
    }

    @Override
    public double area(Square figure) {
        Square square = (Square) figure;
        return Math.pow(size(square), 2);
    }

    private double size(Square square) {
        return Math.sqrt(Math.pow(square.getA().getX() - square.getB().getX(), 2) +
                Math.pow(square.getA().getY() - square.getB().getY(), 2));
    }
}
