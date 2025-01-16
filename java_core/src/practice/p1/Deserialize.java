package practice.p1;

import java.io.*;

public class Deserialize {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream in=new ObjectInputStream(new FileInputStream(new File("employ.ser")));
        Employee e2=(Employee) in.readObject();
        System.out.println("De SErialized");
        System.out.println(e2.toString());
    }
}
