package Strategy;

public class WalkStrategy implements Strategy {
    @Override
    public String getToDestination(String a, String b) {
        return "--> The best way to get from " + a + " to " + b + " on foot <--";
    }
}
