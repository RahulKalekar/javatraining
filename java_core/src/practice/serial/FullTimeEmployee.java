package practice.serial;

import java.io.Serializable;

public class FullTimeEmployee extends Employee implements Serializable {
    private int salary;



    public int getSalary() {
        return salary;
    }
    public FullTimeEmployee(){
        System.out.println("fte ctr");

    }
    public FullTimeEmployee(String name, String password, int salary) {
        super(name, password);
        this.salary=salary;
        System.out.println("In FTE");
    }
}
