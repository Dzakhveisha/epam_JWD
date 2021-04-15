package com.epam.jwd.model;

import com.epam.jwd.strategy.MultyAngleFigurePropertiesStrategy;

import java.util.Arrays;

public class MultyAngleFigure extends Figure {

    private Point points[];

    MultyAngleFigure(Point... points) {
        this.points = points;
        this.propertiesStrategy = MultyAngleFigurePropertiesStrategy.getInstance();
    }

    public Point[] getPoints() {
        return points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MultyAngleFigure that = (MultyAngleFigure) o;
        return Arrays.equals(points, that.points);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(points);
    }

    @Override
    public String toString() {
        return "MultiAngleFigure{" +
                "points=" + Arrays.toString(points) +
                '}';
    }
}
