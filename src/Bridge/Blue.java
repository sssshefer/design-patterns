package Bridge;

public class Blue implements Color {
    String description;
    String hex;

    Blue() {
        this.description = "Relaxing color";
        this.hex = "0000ff";
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
