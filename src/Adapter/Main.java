package Adapter;

public class Main {
    public static void main(String[] args) {
        RoundHole hole = new RoundHole(5);
        RoundPeg roundPeg = new RoundPeg(5);
        System.out.println(hole.fits(roundPeg)); // true

        SquarePeg smallSquarePeg = new SquarePeg(5);
        SquarePeg largeSquarePeg = new SquarePeg(10);
        //hole.fits(smallSquarePeg); // this won't compile (incompatible types)

        SquarePegAdapter smallSquarePegAdapter = new SquarePegAdapter(smallSquarePeg);
        SquarePegAdapter largeSquarePegAdapter = new SquarePegAdapter(largeSquarePeg);
        System.out.println(hole.fits(smallSquarePegAdapter)); // true
        System.out.println(hole.fits(largeSquarePegAdapter));// false
    }
}
