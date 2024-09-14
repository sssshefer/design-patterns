package Prototype;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();

        Circle circle = new Circle();
        circle.X = 10;
        circle.Y = 10;
        circle.setRadius(20);
        shapes.add(circle);

        Shape clonedCircle = circle.clone();
        shapes.add(clonedCircle);

        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(10);
        rectangle.setHeight(20);
        shapes.add(rectangle);

        List<Shape> shapesCopy = new ArrayList<>();
        for (Shape s : shapes) {
            shapesCopy.add(s.clone());
        }

        System.out.println("Shapes and their clones have been created.");
    }
}
