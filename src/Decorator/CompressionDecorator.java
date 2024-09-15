package Decorator;

public class CompressionDecorator extends DataSourceDecorator {
    public CompressionDecorator(DataSource source) {
        super(source);
    }

    @Override
    public Data readData() {
        Data data = wrappee.readData();
        data.setIsCompressed(false);
        System.out.println("Data is decompressed");
        return data;
    }

    @Override
    public void writeData(Data data) {
        data.setIsCompressed(true);
        System.out.println("Data is compressed");
        wrappee.writeData(data);
    }
}
