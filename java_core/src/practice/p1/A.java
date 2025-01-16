package practice.p1;

import java.io.*;

//instance control flow
public class A {
    private int i=22;

    public int getI() {
        return i;
    }

    public A() {
        System.out.println("Inside A");
        i=10;
    }
}
class B extends A implements Serializable{
    private int j;
    public B() {
        System.out.println("Inside B");
        j=30;
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        B b=new B();
        ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(new File("employ.ser")));
        out.writeObject(b);
        System.out.println("Serialized!!");
        ObjectInputStream in=new ObjectInputStream(new FileInputStream(new File("employ.ser")));
        B b2=(B) in.readObject();
        System.out.println(b2.getI());
        System.out.println("De SErialized");
    }
}
