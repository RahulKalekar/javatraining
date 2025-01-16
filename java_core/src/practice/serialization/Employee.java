package practice.serialization;

import practice.serial.FullTimeEmployee;

import java.io.*;
// instance control flow
public class Employee {
    private String name;
    private String password;

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public Employee() {
        System.out.println("ctr of employee");
    }

    public Employee(String name) {
        this.name = name;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FullTimeEmployee e=new FullTimeEmployee();
        ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream((new File("data.ser"))));
        out.writeObject(e);
        System.out.println("serialized");
        ObjectInputStream in =new ObjectInputStream((new FileInputStream(new File("data.ser"))));
        FullTimeEmployee e1=(FullTimeEmployee) in.readObject();
        System.out.println(e1.toString()+" hello");
        System.out.println(e1.getSalary());

    }
}


