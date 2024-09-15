package Decorator;

public interface DataSource {
    public void writeData(Data data);

    Data readData();
}
