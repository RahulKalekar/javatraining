package practice;

import day3n4.Q3.Employee;

import javax.management.RuntimeErrorException;
import java.io.*;

public class Employee1 implements Externalizable {
    private String name;
    private String password;

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Employee1{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
    public Employee1() {
        // No-arg constructor required for Externalizable
    }
    public Employee1(String name, String password) {
        this.name = name;
        this.password = password;
    }
/*
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        try {
            String encryptedPassword = encryptor(password);
            out.writeObject(encryptedPassword);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        try {
            String decryptedPassword = (String) in.readObject();
            this.password = decryptor(decryptedPassword);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
*/
    private String encryptor(String password) {
        return password + "encrypted";
    }

    private String decryptor(String encryptedPassword) {
        return encryptedPassword + " then decrypted";
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Employee1 employee1 = new Employee1("Rahul", "rahul123");
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("employee1.ser"));
        out.writeObject(employee1);
        System.out.println("Serialized");
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File("employee1.ser")));
        Employee1 employee2 = (Employee1) in.readObject();
        System.out.println(employee2.toString());
    }
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(name);
        out.writeObject(password);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name=(String) in.readObject();
        password=(String) in.readObject();
    }
}



