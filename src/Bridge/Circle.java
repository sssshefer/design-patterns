package Bridge;

public class Circle extends Shape {
    Circle(int volume, Color color) {
        super(volume, 0, color);
    }

    public void move() {
        System.out.println("The circle is ease to move so you moved it");
    }
}
