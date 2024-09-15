package Bridge;

public class Shape {

    private int volume;
    private int corners;
    private Color color;

    Shape(int volume, int corners, Color color) {
        this.volume = volume;
        this.corners = corners;
        this.color = color;
    }

    public int getVolume() {
        return this.volume;
    }

    public int getCorners() {
        return this.corners;
    }

    public String getHexColor() {
        return this.color.getHex();
    }

    public String getDescription() {
        return this.color.getDescription();
    }

}
