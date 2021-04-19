package com.epam.jwd.model;

import com.epam.jwd.strategy.SquarePropertiesStrategy;

import java.util.Objects;

public class Square extends Figure {
    private final Point a; // bottom-left
    private final Point b; // top-left
    private final Point c; // top-right
    private final Point d; //bottom-right

    Square(Point a, Point b, Point c, Point d) { // по 4 точкам
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.propertiesStrategy = SquarePropertiesStrategy.getInstance();
    }

    protected Square(Point a, Point b) {   //by top-left and bottom-left points
        long size = a.getY() - b.getY();
        this.a = a;
        this.b = b;
        this.c = new Point(b.getX() + size, b.getY());
        this.d = new Point(b.getX() + size, a.getY());
        this.propertiesStrategy = SquarePropertiesStrategy.getInstance();
    }

    public Point getA() {
        return a;
    }

    public Point getB() {
        return b;
    }

    public Point getC() {
        return c;
    }

    public Point getD() {
        return d;
    }

    public boolean isValid() {
        return !(a.equals(b) || a.equals(c) || a.equals(d) || b.equals(c) || b.equals(d) || c.equals(d));
    }

    @Override
    public boolean isExist() {
        if (Math.abs(a.getY() - b.getY()) != Math.abs(c.getX() - b.getX()))
            return false;
        if (Math.abs(c.getX() - b.getX()) != Math.abs(d.getY() - c.getY()))
            return false;
        if (Math.abs(d.getY() - c.getY()) != Math.abs(d.getX() - a.getX()))
            return false;
        else return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Square square = (Square) o;
        return Objects.equals(a, square.a) && Objects.equals(b, square.b) && Objects.equals(c, square.c) && Objects.equals(d, square.d);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, c, d);
    }

    @Override
    public String toString() {
        return "Square{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                ", d=" + d +
                '}';
    }
}
