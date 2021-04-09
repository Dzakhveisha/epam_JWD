package com.epam.jwd.strategy;

import com.epam.jwd.model.Figure;
import com.epam.jwd.model.Line;

public class LinePropertiesStrategy implements IFigurePropertiesStrategy {
    @Override
    public double perimeter(Figure figure) {
        Line line = (Line) figure;
        return Math.sqrt(Math.pow(line.getFirstPoint().getX() - line.getSecondPoint().getX(), 2) + Math.pow(line.getFirstPoint().getY() - line.getSecondPoint().getY(), 2));
    }

    @Override
    public double area(Figure figure) {
        return 0;
    }
}
