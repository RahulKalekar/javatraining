package practice.p1;

import java.io.*;

public class Employee implements Externalizable {
    //private static final long serialVersionUID=1L;
    private String name;
    transient private String password;

    public Employee() {
    }

    public Employee(String name, String password) {
        this.name = name;
        this.password = password;
    }
    /*
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        String encryptedPass=encrypt1(password);
        out.writeObject(encryptedPass);
    }
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
       String encryptedPass=(String)in.readObject();
       this.password=decrypt1(encryptedPass);
    }
    private String encrypt1(String password){
        return password+" enc";
    }
    private String decrypt1(String password){
        return password+" dec";
    }
    */

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

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(name);
        out.writeObject(password);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name=(String) in.readObject();
        password=(String) in.readObject()+" hellp";
    }
}

