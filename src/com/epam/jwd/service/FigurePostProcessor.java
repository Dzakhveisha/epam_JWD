package com.epam.jwd.service;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.model.Figure;
import com.epam.jwd.service.impl.FigureExistencePostProcessor;

public interface FigurePostProcessor {
    public Figure process(Figure figure) throws FigureException;

    static FigurePostProcessor newInstance(){
        return FigureExistencePostProcessor.INSTANCE;
    }
}
