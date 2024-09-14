package Prototype;

public abstract class Shape {
    protected int X;
    protected int Y;
    protected String color;

    public Shape() {
        // Default constructor
    }

    public Shape(Shape source) {
        this.X = source.X;
        this.Y = source.Y;
        this.color = source.color;
    }

    public abstract Shape clone();
}

