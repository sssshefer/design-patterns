package Decorator;

public class Main {
    public static void main(String[] args) {

        DataSource source = new FileDataSource("testFileName");
        Data data = new Data("Test Author 1", "Test content 1");

        System.out.println("Saving data without decorators:");
        source.writeData(data);

        System.out.println("\nReading data saved to the file without decorators:");
        data = source.readData();
        System.out.println(data.author);
        System.out.println(data.content);
        System.out.println("Data is encrypted: " + data.isEncrypted);
        System.out.println("Data is compressed: " + data.isCompressed + "\n");

        System.out.println("Adding encryption and compression decorators\n");
        source = new CompressionDecorator(new EncryptionDecorator(source));

        System.out.println("Saving data using decorators: ");
        source.writeData(data);

        System.out.println("\nReading data saved to the file using decorators:");
        data = source.readData();
        System.out.println(data.author);
        System.out.println(data.content);
        System.out.println("Data is encrypted: " + data.isEncrypted);
        System.out.println("Data is compressed: " + data.isCompressed + "\n");
    }
}
