package com.epam.jwd.strategy;

import com.epam.jwd.model.Point;
import com.epam.jwd.model.Triangle;

public class TrianglePropertiesStrategy implements FigurePropertiesStrategy<Triangle> {

    private static TrianglePropertiesStrategy instance = null;

    private TrianglePropertiesStrategy() {}

    public static TrianglePropertiesStrategy getInstance() {    // lazy singleton
        if (instance == null) {
            synchronized(TrianglePropertiesStrategy.class) {
                if (instance == null) {
                    instance = new TrianglePropertiesStrategy();
                }
            }
        }
        return instance;
    }

    @Override
    public double perimeter(Triangle figure) {
        Triangle triangle = (Triangle) figure;
        return length(triangle.getA(), triangle.getB()) +
                length(triangle.getB(), triangle.getC()) +
                length(triangle.getA(), triangle.getC());
    }

    @Override
    public double area(Triangle figure) {
        Triangle triangle = (Triangle) figure;
        return Math.abs((triangle.getA().getX() - triangle.getC().getX()) * (triangle.getB().getY() - triangle.getC().getY()) -
                (triangle.getB().getX() - triangle.getC().getX()) * (triangle.getA().getY() - triangle.getC().getY())) / 2.;
    }

    private double length(Point a, Point b) {
        return Math.sqrt(Math.pow(a.getX() - b.getX(), 2) + Math.pow(a.getY() - b.getY(), 2));
    }
}
