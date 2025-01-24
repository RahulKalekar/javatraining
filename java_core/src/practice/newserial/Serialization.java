package practice.newserial;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serialization {

    public static void main(String[] args) throws IOException {
        Employee e=new Employee("RAhul","rahul123");
        ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(new File("employee.ser")));
        out.writeObject(e);
        System.out.println("Serialized!!");
    }
}
