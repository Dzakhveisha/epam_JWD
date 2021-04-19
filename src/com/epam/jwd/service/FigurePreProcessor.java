package com.epam.jwd.service;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.model.Figure;
import com.epam.jwd.model.Point;
import com.epam.jwd.model.SimpleFigureFactory;
import com.epam.jwd.service.impl.FigureExistencePostProcessor;
import com.epam.jwd.service.impl.FigureValidPreProcessor;

public interface FigurePreProcessor {
    public void process(SimpleFigureFactory.FigureType type, Point ... points) throws FigureException;

    static FigurePreProcessor newInstance(){
        return FigureValidPreProcessor.INSTANCE;
    }
}
