package com.epam.jwd.app;

import com.epam.jwd.model.*;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        final FigureFactory figureFactory = new FigureFactory();

        Point[] points = new Point[4];
        points[0] = new Point(20, 20);
        points[1] = new Point(12, 12);
        points[2] = new Point(24, -7);
        points[3] = new Point(21, 21);

        Figure line = figureFactory.createFigure(FigureFactory.FigureType.LINE, points[0], points[1]);
        LOGGER.info("Линия {}",line.toString());

        Figure triangle = figureFactory.createFigure(FigureFactory.FigureType.TRIANGLE,  points[0], points[1],points[1]);
        LOGGER.info("Треугольник {}",triangle.toString());

        Figure square = figureFactory.createFigure(FigureFactory.FigureType.SQUARE, points[0], points[1]);
        LOGGER.info("Квадрат 1 {}",square.toString());

        Figure square2 = figureFactory.createFigure(FigureFactory.FigureType.SQUARE, points[0], points[1], points[2], points[3]);
        LOGGER.info("Квадрат 2 {}",square2.toString());
    }

}
