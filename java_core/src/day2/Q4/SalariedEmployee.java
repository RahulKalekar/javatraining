package day2.Q4;

public class SalariedEmployee extends Employee {
    private double salary;
    private int hikePercentage;
    public SalariedEmployee(String employeeName, double salary) {
        super(employeeName);
        this.salary = salary;
    }

    public double getSalary() {
        if(hikePercentage>0){
            return salary+(salary*hikePercentage)/100;
        }
        return salary;
    }
    @Override
    public void increaseSalary(int hikePercentage){
        salary += salary * hikePercentage / 100;
    }

}
