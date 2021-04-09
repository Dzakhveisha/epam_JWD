package com.epam.jwd.strategy;

import com.epam.jwd.model.Figure;

public interface FigurePropertiesStrategy<T extends Figure> {

    public double perimeter(T figure);

    public double area(T figure);

}
