package Prototype;

public class Rectangle extends Shape {
    private int width;
    private int height;

    public Rectangle() {
        super();
    }

    public Rectangle(Rectangle source) {
        super(source);
        this.width = source.width;
        this.height = source.height;
    }

    public Shape clone() {
        return new Rectangle(this);
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}

