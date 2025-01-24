package practice.serial;

import java.io.*;

public class Employee   {
    private String name;
    private String password;

    public Employee() {
        System.out.println("Default of employee");
        //this.name="Rohan";
    }

    public Employee(String name, String password) {
        this.name = name;
        this.password = password;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

