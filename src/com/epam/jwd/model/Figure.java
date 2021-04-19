package com.epam.jwd.model;

import com.epam.jwd.strategy.FigurePropertiesStrategy;

public abstract class Figure {

  protected FigurePropertiesStrategy propertiesStrategy;

  public abstract boolean isValid();  //check points matching
  public  abstract boolean isExist(); // verification of the possibility of figure existence


  public double area(){
    return propertiesStrategy.area(this);
  }

  public double perimeter(){
    return propertiesStrategy.perimeter(this);
  }
}
