package presentation.serialization;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serialize {
    public static void main(String[] args) throws IOException {
        Employee e=new Employee("Rahul ", "rahul123");
        ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream("employee.ser"));
        out.writeObject(e);
        System.out.println("Serialized");
    }
}
