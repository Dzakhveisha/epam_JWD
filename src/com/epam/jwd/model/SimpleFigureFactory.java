package com.epam.jwd.model;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.factory.FigureFactory;

public enum SimpleFigureFactory implements FigureFactory {
        INSTANCE;

    public enum FigureType {LINE, SQUARE, TRIANGLE, MULTI_ANGLE_FIGURE}


    @Override
    public Figure createFigure(FigureType type, Point... points) throws FigureException {
        Figure figure = null;
        switch (type) {
            case LINE:
                figure = new Line(points[0], points[1]);
                break;
            case SQUARE:
                if (points.length == 4) {
                    figure = new Square(points[0], points[1], points[2], points[3]);
                } else {
                    figure = new Square(points[0], points[1]);
                }
                break;
            case TRIANGLE:
                figure = new Triangle(points[0], points[1], points[2]);
                break;
            case MULTI_ANGLE_FIGURE:
                figure = new MultyAngleFigure(points);
                break;
        }

        return figure;
    }
}
