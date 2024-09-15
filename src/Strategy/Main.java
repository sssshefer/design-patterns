package Strategy;

public class Main {
    public static void main(String[] args) {
        Context context = new Context();

        String startAddress = "Radiradantie";
        String finishAddress = "Patteristonkatu";

        String meansOfTravel = "on foot";

        switch (meansOfTravel){
            case "on foot":
                context.setStrategy(new WalkStrategy());
                break;
            case "by car":
                context.setStrategy(new AutoStrategy());
                break;
        }

        String theBestRoute = context.executeStrategy(startAddress, finishAddress);
        System.out.println("Here is the best route: "+theBestRoute);
    }
}
