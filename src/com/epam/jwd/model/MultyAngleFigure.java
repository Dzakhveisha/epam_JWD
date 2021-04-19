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

    @Override
    public boolean isValid() {
        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++){
                if (points[i].equals(points[j])){
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public  boolean isExist(){
        return true;
    }
}
