package day3.Q3;
import java.io.*;

public class Serialize {
    public static void main(String[] args) {
        Employee employee = new Employee(101, "Rahul", new Address("Kalaburagi", "Karnataka", "India", "random street,near random building"), 50000);
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("src\\day3\\Q3\\employee.ser"))) {
            out.writeObject(employee);
            System.out.println("SErialized!!");
        }
        catch (Exception e) {
            System.err.println(e);
        }
    }
}
