package practice.p1;

import java.io.*;

public class Serialize {
    public static void main(String[] args) throws IOException {
        Employee e=new Employee("Rahul","rahul123");
        ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(new File("employ.ser")));
        out.writeObject(e);
        System.out.println("Serialized!!");
    }
}
