package com.epam.jwd.strategy;

import com.epam.jwd.model.Line;

public class LinePropertiesStrategy implements FigurePropertiesStrategy<Line> {

    private static LinePropertiesStrategy instance = null;

    private LinePropertiesStrategy() {}

    public static LinePropertiesStrategy getInstance() {    // lazy singleton
        if (instance == null) {
            synchronized(LinePropertiesStrategy.class) {
                if (instance == null) {
                    instance = new LinePropertiesStrategy();
                }
            }
        }
        return instance;
    }

    @Override
    public double perimeter(Line line) {
        return Math.sqrt(Math.pow(line.getFirstPoint().getX() - line.getSecondPoint().getX(), 2) + Math.pow(line.getFirstPoint().getY() - line.getSecondPoint().getY(), 2));
    }

    @Override
    public double area(Line line) {
        return 0;
    }
}
