package com.epam.jwd.service.impl;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.exception.FigureNotExistException;
import com.epam.jwd.model.Figure;
import com.epam.jwd.model.Point;
import com.epam.jwd.model.SimpleFigureFactory;
import com.epam.jwd.service.FigurePreProcessor;

public enum FigureValidPreProcessor implements FigurePreProcessor {
    INSTANCE;

    @Override
    public void process(SimpleFigureFactory.FigureType type, Point...points) throws FigureException {
        switch (type){
            case LINE:
                if (points.length != 2){
                    throw new FigureNotExistException("Line must have 2 points in constructor");
                }
                break;
            case SQUARE:
                if (points.length != 2 && points.length !=4){
                    throw new FigureNotExistException("Square must have 2 or 4 points in constructor");
                }
                break;
            case TRIANGLE:
                if (points.length != 3){
                    throw new FigureNotExistException("Triangle must have 3 points in constructor");
                }
                break;
            case MULTI_ANGLE_FIGURE:
                if (points.length >= 4 && points.length <= 6) {
                    break;
                } else {
                    throw new FigureNotExistException("Multyangle must have 4-6 points in constructor");
                }

        }
    }
}
