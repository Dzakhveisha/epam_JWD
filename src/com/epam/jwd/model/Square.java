package com.epam.jwd.model;

import java.util.Objects;

public class Square {
    private Point a; // нижняя левая точка
    private Point b; // верхняя левая точка
    private Point c; // верхняя правая точка
    private Point d; // нижняя правая точка

    public Square(Point a, Point b, Point c, Point d){ // по 4 точкам
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public Square(Point b, long size){ // по верхней левой точке и длине стороны
        this.a = new Point(b.getX(), b.getY() - size);
        this.b = b;
        this.c = new Point(b.getX() + size, b.getY());
        this.d = new Point(b.getX() + size, b.getY() + size);
    }

    public Square(Point a, Point b){   //по верхней левой и нижней левой точке
        long size = a.getY() - b.getY(); // длина стороны квадрата
        this.a = a;
        this.b = b;
        this.c = new Point(b.getX() + size, b.getY());
        this.d = new Point(b.getX() + size, a.getY());
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

    public boolean isSquare(){
        return !( a.equals(b) || a.equals(c) || a.equals(d) || b.equals(c) || b.equals(d) || c.equals(d));
    }

    public boolean isExist(){
        if (Math.abs(a.getY() - b.getY()) != Math.abs(c.getX() - b.getX()) )
            return false;
        if (Math.abs(c.getX() - b.getX()) != Math.abs(d.getY() - c.getY()) )
            return false;
        if (Math.abs(d.getY() - c.getY()) != Math.abs(d.getX() - a.getX()) )
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
