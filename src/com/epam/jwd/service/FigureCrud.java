package com.epam.jwd.service;

import com.epam.jwd.model.Figure;

public interface FigureCrud {

    public Figure create();
    public Figure MultiCreate();
    public Figure find();
    public  Figure findByInd();
    public  Figure update();
}
