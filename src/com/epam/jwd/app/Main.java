package com.epam.jwd.app;

import com.epam.jwd.model.*;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);
    private static final FigureFactory figureFactory = new FigureFactory();

    public static void main(String[] args) {

        Point[] points = new Point[4];
        points[0] = new Point(20, 20);
        points[1] = new Point(12, 12);
        points[2] = new Point(24, -7);
        points[3] = new Point(21, 21);
        int i = 0;
        do {
            LOGGER.info(points[i].toString());
            i++;
        } while (i < points.length);

        Line[] lines = new Line[2];
        lines[0] = (Line) figureFactory.createFigure(FigureFactory.FigureType.LINE, points[0], points[1]);
        lines[1] = (Line) figureFactory.createFigure(FigureFactory.FigureType.LINE, points[1], points[2]);
        for (i = 0; i < lines.length; i++) {
            if (lines[i].isLine()) {
                LOGGER.info("Линия {}",lines[i].toString());
                LOGGER.info("Площадь : {}",lines[i].propertiesStrategy.area(lines[i]));
                LOGGER.info("Периметр : {}",lines[i].propertiesStrategy.perimeter(lines[i]));
            } else {
                LOGGER.error("Объект " + lines[i].toString() + "не является фигурой линия.");
            }
        }

        Triangle[] triangles = new Triangle[2];
        triangles[0] = (Triangle) figureFactory.createFigure(FigureFactory.FigureType.TRIANGLE, points[0], points[1], points[2]);
        triangles[1] = (Triangle) figureFactory.createFigure(FigureFactory.FigureType.TRIANGLE, points[0], points[1], points[3]);
        for (i = 0; i < triangles.length; i++) {
            if (triangles[i].isTriangle()) {
                if (triangles[i].isExists()) {
                    LOGGER.info("Треугольник {}",triangles[i].toString());
                    LOGGER.info("Площадь : {}",triangles[i].propertiesStrategy.area(triangles[i]));
                    LOGGER.info("Периметр : {}",triangles[i].propertiesStrategy.perimeter(triangles[i]));
                } else {
                    LOGGER.error("Треугольник {} не может существовать.", triangles[i].toString());
                }
            } else {
                LOGGER.error("Объект {} не является фигурой треугольник",triangles[i].toString());
            }
        }


        Square[] squares = new Square[2];
        squares[0] = (Square) figureFactory.createFigure(FigureFactory.FigureType.SQUARE, points[0], points[1], points[2], points[3]);
        squares[1] = (Square) figureFactory.createFigure(FigureFactory.FigureType.SQUARE, points[0], new Point(20,30));
        for (i = 0; i < squares.length; i++) {
            if (squares[i].isSquare()) {
                if (squares[i].isExist()) {
                    LOGGER.info("Квадрат {}", squares[i].toString());
                    LOGGER.info("Площадь : {}",squares[i].propertiesStrategy.area(squares[i]));
                    LOGGER.info("Периметр: {}",squares[i].propertiesStrategy.perimeter(squares[i]));
                } else {
                    LOGGER.error("Фигура {} не может являться квадратом (существовать).", squares[i].toString());
                }
            } else {
                LOGGER.error("Объект {} не является фигурой квадрат\n", squares[i].toString());
            }
        }

        MultyAngleFigure polygons[] = new MultyAngleFigure[3];
        polygons[0] = (MultyAngleFigure) figureFactory.createFigure(FigureFactory.FigureType.MULTI_ANGLE_FIGURE,
                points[0], points[1], points[2], points[3], new Point(32, 90));
        polygons[1] = (MultyAngleFigure) figureFactory.createFigure(FigureFactory.FigureType.MULTI_ANGLE_FIGURE,
                new Point(0,0), new Point(-500, 0), new Point(0, -500), new Point(-500, -500));
        polygons[2] = (MultyAngleFigure) figureFactory.createFigure(FigureFactory.FigureType.MULTI_ANGLE_FIGURE,
                points[0], points[1], points[2], points[3], new Point(1,23), new Point(20,98));

        for (i = 0; i < polygons.length; i++){
            LOGGER.info("Многоугольник {}", polygons[i].toString());
            LOGGER.info("Площадь: {}",polygons[i].propertiesStrategy.area(polygons[i]));
            LOGGER.info("Периметр: {}",polygons[i].propertiesStrategy.perimeter(polygons[i]));
        }

    }

}
