package com.epam.jwd.decorator;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.factory.FigureFactory;
import com.epam.jwd.model.Figure;
import com.epam.jwd.model.Point;
import com.epam.jwd.model.SimpleFigureFactory;
import com.epam.jwd.service.FigurePostProcessor;
import com.epam.jwd.service.FigurePreProcessor;

public class PreProcessingFactory extends FigureDecorator{

    private final FigurePreProcessor preProcessor = FigurePreProcessor.newInstance();

    public PreProcessingFactory(FigureFactory factory) {
        super(factory);
    }

    @Override
    public Figure createFigure(SimpleFigureFactory.FigureType type, Point... points) throws FigureException {
        preProcessor.process(type, points);
        return factory.createFigure(type, points);
    }
}
