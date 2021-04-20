package com.epam.jwd.repository.impl.searchByCriteria;

import com.epam.jwd.model.Figure;
import com.epam.jwd.model.SimpleFigureFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SearchBuilder {

    private List<Predicate<Figure>> predicates;

    public SearchBuilder() {
        this.predicates = new ArrayList<>();
    }

    public Predicate<Figure> build() {
        return (figure -> {
            boolean result = true;
            for (Predicate<Figure> predicate: predicates) {
                result &= predicate.test(figure);
            }
            return result;
        });
    }

    public SearchBuilder searchByBiggestArea(double maxArea){
        predicates.add(figure -> figure.area() < maxArea);
        return this;
    }

    public SearchBuilder searchBySmallestArea( double minArea){
        predicates.add(figure -> figure.area() > minArea);
        return this;
    }

    public SearchBuilder searchByBiggestPerimeter( double maxPerimeter){
        predicates.add(figure -> figure.perimeter() < maxPerimeter);
        return this;
    }

    public SearchBuilder searchBySmallestPerimeter( double minPerimeter){
        predicates.add(figure -> figure.perimeter() > minPerimeter);
        return this;
    }

}
