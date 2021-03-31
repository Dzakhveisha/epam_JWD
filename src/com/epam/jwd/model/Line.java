package com.epam.jwd.model;

import java.util.Objects;

public class Line {
    private Point firstPoint;
    private Point secondPoint;

    public Line(Point firstPoint, Point secondPoint) {
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
    }

    public Point getFirstPoint() {
        return firstPoint;
    }

    public Point getSecondPoint() {
        return secondPoint;
    }

    public boolean isLine() {
        return firstPoint.equals(secondPoint);
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
