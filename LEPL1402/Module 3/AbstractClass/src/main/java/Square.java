package main.java;

public class Square implements Shape{
    @Override
    public double getArea(double d) {
        return d * d;
    }

    @Override
    public double getPerimeter(double d) {
        return d * 4;
    }
}
