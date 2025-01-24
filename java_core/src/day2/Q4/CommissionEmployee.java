package day2.Q4;

public class CommissionEmployee extends Employee {
    private float percentageSales;
    private double weeklySales;

    public CommissionEmployee(String employeeName, double weeklySales, float percentageSales) {
        super(employeeName);
        this.weeklySales = weeklySales;
        this.percentageSales = percentageSales;

    }

    public float getPercentageSales() {
        return percentageSales;
    }

    public void setPercentageSales(float percentageSales) {
        this.percentageSales = percentageSales;
    }

    public double getWeeklySales() {
        return weeklySales;
    }

    public void setWeeklySales(double weeklySales) {
        this.weeklySales = weeklySales;
    }
    public double getSalary(){
        return (percentageSales*weeklySales)/100;
    }
    @Override
    public void increaseSalary(int percentage) {
        percentageSales += percentageSales * percentage / 100;
    }
}
