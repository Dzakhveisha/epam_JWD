package com.epam.jwd.app;

import com.epam.jwd.factory.FigureFactory;
import com.epam.jwd.model.*;
import com.epam.jwd.repository.StorageCrud;
import com.epam.jwd.repository.impl.searchByCriteria.SearchBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.epam.jwd.model.SimpleFigureFactory.FigureType.*;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);
    private static  final StorageCrud FIGURE_STORAGE = StorageCrud.newInstance();

    public static void main(String[] args){

        ArrayList<Point> points = new ArrayList<>();
        points.add(new Point(20, 20));
        points.add(new Point(12, 12));
        points.add(new Point(0, 20));
        points.add(new Point(10, 23));
        for (Point point: points) {
            LOGGER.info(point.toString());
        }

        FIGURE_STORAGE.create(LINE,points.get(0), points.get(2));
        FIGURE_STORAGE.create(LINE,points.get(0), points.get(2));
        FIGURE_STORAGE.create(TRIANGLE,points.get(0), points.get(2), points.get(3));
        FIGURE_STORAGE.create(MULTI_ANGLE_FIGURE, points.get(0), points.get(1),points.get(2), points.get(3));
        FIGURE_STORAGE.multiCreate(SQUARE, 2, points.get(0), points.get(2));
        FIGURE_STORAGE.update(0,TRIANGLE, points.get(0), points.get(2),points.get(1));
        FIGURE_STORAGE.update(2,LINE,points.get(0), points.get(2));

        FIGURE_STORAGE.delete(2);
        FIGURE_STORAGE.findByInd(2);
        List<Figure> figureList = FIGURE_STORAGE.find(new SearchBuilder().searchByBiggestArea(100).searchBySmallestArea(10).build());
        System.out.println(Arrays.toString(figureList.toArray()) + "\n");

        for (Figure figure: FIGURE_STORAGE) {
            LOGGER.info("FIGURE: {}", figure.toString());
            LOGGER.info("  area: {}", figure.area());
            LOGGER.info("  perimeter: {}", figure.perimeter());
        }

    }

}
