package com.epam.jwd.decorator;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.factory.FigureFactory;
import com.epam.jwd.model.Figure;
import com.epam.jwd.model.Point;
import com.epam.jwd.model.SimpleFigureFactory;
import com.epam.jwd.service.FigurePostProcessor;
import com.epam.jwd.service.impl.FigureExistencePostProcessor;

public class PostProcessingFactory extends FigureDecorator{

    public PostProcessingFactory(FigureFactory factory) {
        super(factory);
    }
    private final FigurePostProcessor postProcessor = FigurePostProcessor.newInstance();

    @Override
    public Figure createFigure(SimpleFigureFactory.FigureType type, Point... points) throws FigureException {
        Figure figure = factory.createFigure(type, points);
        postProcessor.process(figure);
        return  figure;
    }
}
