package com.epam.jwd.app;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.factory.FigureFactory;
import com.epam.jwd.model.*;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);
    private static final FigureFactory SYMPLE_FIGURE_FACTORY = FigureFactory.newInstance();

    public static void main(String[] args){

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

            try{
            Line[] lines = new Line[2];
            lines[0] = (Line) SYMPLE_FIGURE_FACTORY.createFigure(SimpleFigureFactory.FigureType.LINE, points[0], points[1]);
            lines[1] = (Line) SYMPLE_FIGURE_FACTORY.createFigure(SimpleFigureFactory.FigureType.LINE, points[1], points[2]);
            for (i = 0; i < lines.length; i++) {
                LOGGER.info("Line {}", lines[i].toString());
                LOGGER.info("area: {}", lines[i].area());
                LOGGER.info("perimeter: {}", lines[i].perimeter());
            }
            }
            catch (Exception e){
                LOGGER.error(e.getMessage());
            }

            try{
            Triangle[] triangles = new Triangle[2];
            triangles[0] = (Triangle) SYMPLE_FIGURE_FACTORY.createFigure(SimpleFigureFactory.FigureType.TRIANGLE, points[0], points[1], points[2]);
            triangles[1] = (Triangle) SYMPLE_FIGURE_FACTORY.createFigure(SimpleFigureFactory.FigureType.TRIANGLE, points[0], points[1], points[3]);
            for (i = 0; i < triangles.length; i++) {
                LOGGER.info("Triangle {}", triangles[i].toString());
                LOGGER.info("area: {}", triangles[i].area());
                LOGGER.info("perimeter: {}", triangles[i].perimeter());
            }
            }
            catch (Exception e){
                LOGGER.error(e.getMessage());
            }

            try{
            Square[] squares = new Square[2];
            squares[0] = (Square) SYMPLE_FIGURE_FACTORY.createFigure(SimpleFigureFactory.FigureType.SQUARE, points[0], points[1], points[2], points[3]);
            squares[1] = (Square) SYMPLE_FIGURE_FACTORY.createFigure(SimpleFigureFactory.FigureType.SQUARE, points[0], new Point(20, 30));
            for (i = 0; i < squares.length; i++) {
                LOGGER.info("Square {}", squares[i].toString());
                LOGGER.info("area: {}", squares[i].area());
                LOGGER.info("perimeter: {}", squares[i].perimeter());
            }
            }
            catch (Exception e){
                LOGGER.error(e.getMessage());
            }


            try{
            MultyAngleFigure polygons[] = new MultyAngleFigure[3];
            polygons[0] = (MultyAngleFigure) SYMPLE_FIGURE_FACTORY.createFigure(SimpleFigureFactory.FigureType.MULTI_ANGLE_FIGURE,
                    points[0], points[1], points[2], points[3], new Point(32, 90));
            polygons[1] = (MultyAngleFigure) SYMPLE_FIGURE_FACTORY.createFigure(SimpleFigureFactory.FigureType.MULTI_ANGLE_FIGURE,
                    new Point(0, 0), new Point(-500, 0), new Point(0, -500), new Point(-500, -500));
            polygons[2] = (MultyAngleFigure) SYMPLE_FIGURE_FACTORY.createFigure(SimpleFigureFactory.FigureType.MULTI_ANGLE_FIGURE,
                    points[0], points[1], points[2], points[3], new Point(1, 23), new Point(20, 98));

            for (i = 0; i < polygons.length; i++) {
                LOGGER.info("polygon {}", polygons[i].toString());
                LOGGER.info("area: {}", polygons[i].area());
                LOGGER.info("perimeter: {}", polygons[i].perimeter());
            }
            }
            catch (Exception e){
                LOGGER.error(e.getMessage());
            }

    }

}
