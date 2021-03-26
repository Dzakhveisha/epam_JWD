package com.epam.jwd.model;

import java.util.Objects;

public class Square {
    private Point a; // нижняя левая точка
    private Point b; // верхняя левая точка
    private Point c; // верхняя права точка
    private Point d; // нижняя правая точка

    public Square(Point a, Point b, Point c, Point d){ //
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    public Square(Point b, Point d){ //по верхней левой и нижней правой точках
        this.a = new Point(b.getX(), d.getY());
        this.b = b;
        this.c = new Point(d.getX(), b.getY());
        this.d = d;
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
