package practice.newserial;

import java.io.*;

public class Deserialization {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream in=new ObjectInputStream(new FileInputStream(new File("employee.ser")));
        Employee e2=(Employee)in.readObject();
        System.out.println(e2.toString());
        System.out.println("DEserialized");
    }
}
