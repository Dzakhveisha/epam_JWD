package com.epam.jwd.model;

import com.epam.jwd.strategy.LinePropertiesStrategy;

import java.util.Objects;

public class Line extends Figure {
    private final Point firstPoint;
    private final Point secondPoint;

    Line(Point firstPoint, Point secondPoint) {
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
        this.propertiesStrategy = LinePropertiesStrategy.getInstance();
    }

    public Point getFirstPoint() {
        return firstPoint;
    }

    public Point getSecondPoint() {
        return secondPoint;
    }

    @Override
    public boolean isValid() {
        return !firstPoint.equals(secondPoint);
    }

    @Override
    public boolean isExist() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(firstPoint, line.firstPoint) && Objects.equals(secondPoint, line.secondPoint);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstPoint, secondPoint);
    }

    @Override
    public String toString() {
        return "Line{" +
                "firstPoint=" + firstPoint +
                ", secondPoint=" + secondPoint +
                '}';
    }

}
