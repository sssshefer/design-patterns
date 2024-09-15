package Strategy;

public class Context {
    Strategy strategy;

    void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    String executeStrategy(String a, String b) {
        return strategy.getToDestination(a, b);
    }
}
