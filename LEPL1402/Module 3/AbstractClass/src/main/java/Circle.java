package main.java;

public class Circle implements Shape {
    @Override
    public double getArea(double d) {
        return Math.PI * (d * d);
    }

    @Override
    public double getPerimeter(double d) {
        return Math.PI * (d * 2);
    }
}
