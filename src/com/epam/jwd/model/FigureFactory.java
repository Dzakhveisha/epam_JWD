package com.epam.jwd.model;

public class FigureFactory {

    public enum FigureType {LINE, SQUARE, TRIANGLE};
    public Figure createFigure (FigureType type, Point ... points) {

        Figure figure = null;

        switch (type) {
            case LINE:
                if (points.length == 2) {
                    figure = new Line(points[0], points[1]);
                }
                break;

            case SQUARE:
                if (points.length == 4) {
                    figure = new Square(points[0], points[1], points[2], points[3]);
                }
                else{
                    figure = new Square(points[0], points[1]);
                }
                break;

            case TRIANGLE:
                if (points.length == 3) {
                    figure = new Triangle(points[0], points[1], points[2]);
                }
                break;
        }

        return figure;
    }

}
