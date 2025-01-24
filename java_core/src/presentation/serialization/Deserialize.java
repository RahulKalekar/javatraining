package presentation.serialization;

import javax.management.ObjectName;
import java.io.*;

public class Deserialize {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Employee e2=new Employee();
        ObjectInputStream in=new ObjectInputStream(new FileInputStream(new File("employee.ser")));
        e2=(Employee)in.readObject();
        System.out.println(e2.toString());
        System.out.println("DEserialized");
    }
}
