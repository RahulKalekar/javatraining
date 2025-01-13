package day3n4.Q3;

import java.io.Serializable;

public class Employee implements Serializable {
    int id;
    String name;
    Address address;
    transient double salary;

    public Employee(int id, String name, Address address, double salary) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.salary = salary;
    }

    void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Address: " + address.exactAddress + "\nCity: " + address.city + "State: " + address.state + "Country: " + address.country);
        System.out.println("Salary: " + salary);
    }
}