package practice.newserial;

import java.io.*;

public class Employee implements Externalizable{
    private String name;
    private String password;
    public Employee(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public Employee() {
    }

    private void writeObject(ObjectOutputStream out) throws java.io.IOException {
        out.defaultWriteObject(); //default needed
        out.writeObject(password+" encrypted");
    }
    private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
        in.defaultReadObject(); //default needed
        password = (String) in.readObject();
    }
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Employee{");
        sb.append("name='").append(name).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append('}');
        return sb.toString();
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
        name=(String)in.readObject();
        password=(String)in.readObject();
    }
}
