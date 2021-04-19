package com.epam.jwd.factory;

import com.epam.jwd.decorator.PostProcessingFactory;
import com.epam.jwd.decorator.PreProcessingFactory;
import com.epam.jwd.exception.FigureException;
import com.epam.jwd.model.Figure;
import com.epam.jwd.model.SimpleFigureFactory;
import  com.epam.jwd.model.SimpleFigureFactory.FigureType;
import  com.epam.jwd.model.Point;

public interface FigureFactory {
    public Figure createFigure(FigureType type, Point... points) throws FigureException;

    static FigureFactory newInstance(){
       return new PostProcessingFactory(   // check points match and validation of form
               new PreProcessingFactory(   // count of points
                       SimpleFigureFactory.INSTANCE
               ));
    }
}
