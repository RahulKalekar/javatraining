package day2.Q4;

public abstract class Employee {
    private String employeeName;
    private int employeeId;
    private static int idCounter=100;

    public Employee(String employeeName) {
        this.employeeName = employeeName;
        this.employeeId=idCounter++;
    }
    public abstract double getSalary();     //declare here define wherever required in other classes
    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getEmployeeId() {
        return employeeId;
    }
    @Override
    public String toString() {              //by default toString function is used to print a normal arraylist
                                            //since we have a special object array we need to override that function and write own logic
        return "Employee{name= " + employeeName + " id= "+employeeId+" weekly salary= "+ getSalary()+ " } ";
    }

    public abstract void increaseSalary(int hikePercentage);
}
