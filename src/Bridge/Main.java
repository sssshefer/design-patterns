package Bridge;

public class Main {

    public static void main(String[] args) {
        Color red = new Red();
        Square square = new Square(16, red);

        System.out.println(square.getCorners());
        System.out.println(square.getHexColor());
        System.out.println(square.getDescription());

        Color blue = new Blue();
        Circle circle = new Circle(12, blue);

        System.out.println("\n" + circle.getCorners());
        System.out.println(circle.getHexColor());
        System.out.println(circle.getDescription());
        circle.move();
    }
}
