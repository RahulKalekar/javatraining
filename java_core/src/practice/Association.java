package practice;
import java.util.HashSet;
import java.util.Set;

//Example of association
//association is generic term for relationship
//It does not indicate ownership

class Bank {
    private String bankName;
    private Set<Employee> employees;
    //constructor for bank name
    Bank(String bankName){
        this.bankName=bankName;
    }
    //now we need to make a function to return the bankName via encapsulation
    //because we declared it private for security reasons.
    public String getBankName(){
        return this.bankName;
    }
    //for each bank we need to set employees
    public void setEmployees(Set<Employee> employees){
        this.employees=employees;
    }
    //return those set employees
    public Set<Employee> getEmployees(){
        return this.employees;
    }
}

//Employee class
class Employee{
    private String employeeName;
    //constructor
    public Employee(String employeeName){
        this.employeeName=employeeName;
    }
    public String getEmployeeName(){
        return this.employeeName;
    }
}


public class Association{
    public static void main(String[] args){
        Employee emp1= new Employee("Rahul");
        Employee emp2=new Employee("Rohan");
        Set<Employee> employees= new HashSet<>();
        employees.add(emp1);
        employees.add(emp2);
        Bank bank=new Bank("SBI");
        bank.setEmployees(employees);
        for(Employee emp:bank.getEmployees()){
            System.out.println(emp.getEmployeeName()+" belongs to bank "+bank.getBankName());
        }
    }
}