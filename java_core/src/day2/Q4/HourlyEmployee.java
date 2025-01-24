package day2.Q4;

public class HourlyEmployee extends Employee {
    private int hoursWorked;
    private int hourlyRate;

    public HourlyEmployee(String employeeName, int hoursWorked, int hourlyRate) {
        super(employeeName);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public int getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(int hourlyRate) {
        this.hourlyRate = hourlyRate;
    }
    public double getSalary() {
        return hoursWorked*hourlyRate;
    }
    public void increaseSalary(int percentage) {
        hourlyRate += hourlyRate * percentage / 100;
    }
}
