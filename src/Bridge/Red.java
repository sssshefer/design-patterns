package Bridge;

public class Red implements Color {
    String description;
    String hex;

    Red() {
        this.description = "Aggressive color";
        this.hex = "ff0000";
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getHex() {
        return hex;
    }
}
