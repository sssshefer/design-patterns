package Decorator;

public class FileDataSource implements DataSource {
    String filename;
    Data data;

    FileDataSource(String filename) {
        this.filename = filename;
    }

    public void writeData(Data data) {
        this.data = data;
        System.out.println("Data is successfully saved to the file!");
    }

    public Data readData() {
        return data;
    }
}
