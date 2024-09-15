package Adapter;

public class RoundHole {
    private int radius;

    public int getRadius() {
        return radius;
    }

    public RoundHole(int radius) {
        this.radius = radius;
    }

    public Boolean fits(RoundPeg peg) {
        return this.getRadius() >= peg.getRadius();
    }
}
