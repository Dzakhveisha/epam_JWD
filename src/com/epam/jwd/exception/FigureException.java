package com.epam.jwd.exception;

public abstract class FigureException extends Exception{

    public FigureException(){
        super();
    }

    public FigureException(String message) {
        super(message);
    }
}
