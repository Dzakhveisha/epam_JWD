package com.epam.jwd.strategy;

import com.epam.jwd.model.MultyAngleFigure;
import com.epam.jwd.model.Point;


public class MultyAngleFigurePropertiesStrategy implements FigurePropertiesStrategy<MultyAngleFigure>{

    private static MultyAngleFigurePropertiesStrategy instance = null;

    private MultyAngleFigurePropertiesStrategy() {}

    public static MultyAngleFigurePropertiesStrategy getInstance() {
        if (instance == null) {
            synchronized(LinePropertiesStrategy.class) {
                if (instance == null) {
                    instance = new MultyAngleFigurePropertiesStrategy();
                }
            }
        }
        return instance;
    }

    @Override
    public double perimeter(MultyAngleFigure figure) {
        double result = 0;
        for (int i = 1; i < figure.getPoints().length; i ++){
            result += length(figure.getPoints()[i - 1], figure.getPoints()[i]) ;
        }
        result += length(figure.getPoints()[0], figure.getPoints()[figure.getPoints().length - 1]) ;
        return result;
    }

    @Override
    public double area(MultyAngleFigure figure) {
        int n = figure.getPoints().length;
        double sum = 0;
        double x1 = figure.getPoints()[0].getX();
        double y1 = figure.getPoints()[0].getY();
        double x2 = 0, y2 = 0;
        for(int i = 1; i < n; i++){
            x2 = figure.getPoints()[i].getX();
            y2 = figure.getPoints()[i].getY();
            sum += ( x1 + x2) * ( y2 - y1 );
            x1 = x2;
            y1 = y2;
        }
        sum += ( figure.getPoints()[0].getX() + x2) * ( y2 - figure.getPoints()[0].getY());
        return Math.abs(sum) / 2;
    }

    private double length(Point a, Point b) {
        return Math.sqrt(Math.pow(a.getX() - b.getX(), 2) + Math.pow(a.getY() - b.getY(), 2));
    }
}
