package com.epam.jwd.service.impl;

import com.epam.jwd.factory.FigureFactory;
import com.epam.jwd.model.Figure;
import com.epam.jwd.service.FigureCrud;

import java.util.ArrayList;

public class FigureCrudImpl implements FigureCrud {

    private ArrayList<Figure> figures;
    private static final FigureFactory SIMPLE_FIGURE_FACTORY = FigureFactory.newInstance();

    public FigureCrudImpl() {
        this.figures = new ArrayList<>();
    }

    @Override
    public Figure create() {
        return null;
    }

    @Override
    public Figure MultiCreate() {
        return null;
    }

    @Override
    public Figure find() {
        return null;
    }

    @Override
    public Figure findByInd() {
        return null;
    }

    @Override
    public Figure update() {
        return null;
    }
}
