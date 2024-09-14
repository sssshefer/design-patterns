package Prototype;

public class Circle extends Shape {
    private int radius;

    public Circle() {
        super();
    }

    public Circle(Circle source) {
        super(source);
        this.radius = source.radius;
    }

    public Shape clone() {
        return new Circle(this);
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
}