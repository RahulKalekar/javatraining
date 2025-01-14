package day3n4.Q3;
import java.io.*;

public class Deserialize {
    public static void main(String[] args) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("src\\day3n4\\Q3\\employee.ser"))) {
            Employee employee = (Employee) in.readObject();
            System.out.println("deserialized!!");
            employee.display();

        }
        catch (Exception e) {
            System.err.println(e);
        }
    }
}