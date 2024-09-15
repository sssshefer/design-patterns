package Adapter;

public class SquarePegAdapter extends RoundPeg {
    SquarePeg peg;

    public SquarePegAdapter(SquarePeg peg) {
        super(0);
        this.peg = peg;
    }

    public int getRadius() {
        return (int) (this.peg.getWidth() * Math.sqrt(2) / 2);
    }
}
