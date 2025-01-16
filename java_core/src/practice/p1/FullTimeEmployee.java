package practice.p1;

public class FullTimeEmployee extends Employee{
    private int salary;
    public FullTimeEmployee(String name, String password,int salary) {
        super(name, password);
        this.salary=salary;
    }
}
