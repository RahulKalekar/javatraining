package day2;
/*Q1: Implement following UML diagram, Write a program to test class.*/
public class Q1 {
    public static void main(String[] args) {
        Employee employee = new Employee(1, "Rahul", "Kalekar", 50000);

        employee.raiseSalary(5);
        System.out.println(employee);
    }
}
class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private int salary;
    Employee(int id,String firstName,String lastName,int salary){
        this.id=id;
        this.firstName=firstName;
        this.lastName=lastName;
        this.salary=salary;
    }
    public int getID(){
        return this.id;
    }
    public String getFirstName(){
        return this.firstName;
    }
    public String getLastName(){
        return this.lastName;
    }
    public String getName(){
        return this.firstName+" "+this.lastName;
    }
    public int getSalary(){
        return this.salary;
    }
    public void setSalary(int salary){
        this.salary=salary;
    }
    public int getAnnualSalary(){
        return this.salary*12;
    }
    public int raiseSalary(int percent){
        salary=salary+(salary*percent)/100;
        return salary;
    }
    public String toString(){
        return ("Employee[id= "+this.id+" name= "+this.firstName+" "+this.lastName+" ,salary= "+this.salary+"]");
    }
}




