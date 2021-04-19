package com.epam.jwd.decorator;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.factory.FigureFactory;
import com.epam.jwd.model.Figure;
import com.epam.jwd.model.Point;
import com.epam.jwd.model.SimpleFigureFactory;

public class FigureDecorator implements FigureFactory {

    protected final FigureFactory factory;

    public FigureDecorator(FigureFactory factory) {
        this.factory = factory;
    }

    @Override
    public Figure createFigure(SimpleFigureFactory.FigureType type, Point... points) throws FigureException {
        return factory.createFigure(type, points);
    }

}
