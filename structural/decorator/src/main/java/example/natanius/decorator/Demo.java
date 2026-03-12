package example.natanius.decorator;


import example.natanius.decorator.decorators.CompressionDecorator;
import example.natanius.decorator.decorators.DataSource;
import example.natanius.decorator.decorators.DataSourceDecorator;
import example.natanius.decorator.decorators.EncryptionDecorator;
import example.natanius.decorator.decorators.FileDataSource;

public class Demo {
    public static void main(String[] args) {
        String salaryRecords = "Name,Salary\nJohn Smith,100000\nSteven Jobs,912000";
        DataSourceDecorator encoded = new CompressionDecorator(
                                         new EncryptionDecorator(
                                             new FileDataSource("OutputDemo.txt")));
        encoded.writeData(salaryRecords);
        DataSource plain = new FileDataSource("OutputDemo.txt");

        System.out.println("- Input ----------------");
        System.out.println(salaryRecords);
        System.out.println("- Encoded --------------");
        System.out.println(plain.readData());
        System.out.println("- Decoded --------------");
        System.out.println(encoded.readData());
    }
}
