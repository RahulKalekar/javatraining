package practice.serial;

import java.io.*;

public class Serialization {
    public static void main(String[] args) throws IOException {
        FullTimeEmployee e=new FullTimeEmployee("Rahul","rahul129",50000);
        ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(new File("emp.ser")));
        out.writeObject(e);
        System.out.println("Serialized");
    }
}
