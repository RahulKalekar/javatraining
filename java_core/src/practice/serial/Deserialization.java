package practice.serial;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Deserialization {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream in=new ObjectInputStream(new FileInputStream(new File("emp.ser")));
        FullTimeEmployee e2=(FullTimeEmployee)in.readObject();
        System.out.println(e2.toString());
        System.out.println(e2.getSalary());

    }
}
