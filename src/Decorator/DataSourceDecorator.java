package Decorator;

public class DataSourceDecorator implements DataSource {
    DataSource wrappee;

    DataSourceDecorator(DataSource wrappee) {
        this.wrappee = wrappee;
    }

    public void writeData(Data data) {
        wrappee.writeData(data);
    }

    public Data readData() {
        return wrappee.readData();
    }
}
