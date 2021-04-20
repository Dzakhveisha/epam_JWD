package com.epam.jwd.repository.impl;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.factory.FigureFactory;
import com.epam.jwd.model.Figure;
import com.epam.jwd.model.Point;
import com.epam.jwd.model.SimpleFigureFactory;
import com.epam.jwd.repository.StorageCrud;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static com.sun.xml.internal.ws.api.model.wsdl.WSDLBoundOperation.ANONYMOUS.optional;

public enum FigureStorageCrud implements StorageCrud{
    INSTANCE;

    private final Logger LOGGER = LogManager.getLogger(StorageCrud.class);

    private static final FigureFactory SIMPLE_FIGURE_FACTORY = FigureFactory.newInstance();
    private static ArrayList<Figure> figureArrayList = new ArrayList<>();
    private static int figureCount = 0;

    @Override
    public boolean create(SimpleFigureFactory.FigureType type, Point... points) {
        boolean result = false;
        try {
            Figure figure = SIMPLE_FIGURE_FACTORY.createFigure(type, points);
            figureArrayList.add(figure);
            figureCount++;
            result = true;
        }
        catch (FigureException e){
            LOGGER.error(e.getMessage());
        }
        return result;
    }

    @Override
    public void multiCreate(SimpleFigureFactory.FigureType type, int count, Point... points) {
        for (int i = 0 ; i < count ; i++){
            create(type, points);
        }
    }

    @Override
    public boolean delete(int index) {
        if (index < figureCount) {
            Figure figure = figureArrayList.remove(index);
            figureCount--;
            return true;
        }
        else return false;
    }

    @Override
    public Optional<Figure> findByInd(int index) {
        if (index >= 0 && index < figureCount) {
            return Optional.of(figureArrayList.get(index));
        }
        else return Optional.empty();
    }

    @Override
    public List<Figure> find(Predicate<Figure> predicate) {
        return figureArrayList.stream().filter(predicate).collect(Collectors.toList());
    }

    @Override
    public boolean update(int index, SimpleFigureFactory.FigureType type, Point... points) {
        boolean result = false;
        if (findByInd(index).isPresent()){
            try {
                Figure figure = SIMPLE_FIGURE_FACTORY.createFigure(type, points);
                figureArrayList.set(index,figure);
                result = true;
            }
            catch (FigureException e){
                LOGGER.error(e.getMessage());
            }
        }
        return result;
    }

    @Override
    public Iterator<Figure> iterator() {
        return new Iterator<Figure>() {
            private int pointer = 0;

            @Override
            public boolean hasNext() {
                return pointer < figureArrayList.size();
            }

            @Override
            public Figure next() {
                return figureArrayList.get(pointer++);
            }
        };
    }
}
