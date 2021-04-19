package com.epam.jwd.service.impl;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.exception.FigureNotExistException;
import com.epam.jwd.model.Figure;
import com.epam.jwd.service.FigurePostProcessor;

public enum FigureExistencePostProcessor implements FigurePostProcessor {
    INSTANCE;

    @Override
    public Figure process(Figure figure) throws FigureException {
        if (!figure.isValid() || !figure.isExist()){
            throw new FigureNotExistException("figure is not valid !");
        }

        return figure;
    }
}
