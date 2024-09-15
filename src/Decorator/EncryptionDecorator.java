package Decorator;

public class EncryptionDecorator extends DataSourceDecorator {

    public EncryptionDecorator(DataSource source) {
        super(source);
    }

    @Override
    public Data readData() {
        Data data = wrappee.readData();
        data.isEncrypted = false;
        System.out.println("Data is decrypted");
        return data;
    }

    @Override
    public void writeData(Data data) {
        data.setIsEncrypted(true);
        System.out.println("Data is encrypted");
        super.writeData(data);
    }
}
