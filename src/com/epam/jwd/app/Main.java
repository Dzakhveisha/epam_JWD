package com.epam.jwd.app;

import com.epam.jwd.model.Line;
import com.epam.jwd.model.Point;
import com.epam.jwd.model.Square;
import com.epam.jwd.model.Triangle;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class.getName());

    public static void main(String[] args) {
        Point points[] = new Point[4];
        points[0] = new Point(20, 20);
        points[1] = new Point(12, 12);
        points[2] = new Point(24, -7);
        points[3] = new Point(21, 21);
        int i = 0;
        do {
            LOGGER.info(points[i].toString());
            i++;
        } while (i < points.length);

        Line lines[] = new Line[2];
        lines[0] = new Line(points[0], points[1]);
        lines[1] = new Line(points[3], points[3]);
        for (i = 0; i < lines.length; i++) {
            if (lines[i].isFigure()) {
                LOGGER.info(lines[i].toString());
            } else {
                LOGGER.error("Объект " + lines[i].toString() + "не является фигурой.");
            }
        }

        Triangle triangles[] = new Triangle[2];
        triangles[0] = new Triangle(points[0], points[2], points[2]);
        triangles[1] = new Triangle(points[2], points[3], points[0]);
        for (i = 0; i < triangles.length; i++) {
            if (triangles[i].isFigure()) {
                if (triangles[i].isExists()) {
                    LOGGER.info(triangles[i].toString());
                } else {
                    LOGGER.error("Треугольник " + triangles[i].toString() + "не может существовать.");
                }
            } else {
                LOGGER.error("Объект " + triangles[i].toString() + "не является фигурой.");
            }
        }

        Square squares[] = new Square[1];
        squares[0] = new Square(points[0], points[1], points[2], points[3]);
        for (i = 0; i < squares.length; i++) {
            LOGGER.info(squares[i].toString());
        }
    }

}
