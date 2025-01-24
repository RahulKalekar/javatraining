package day2.Q5;

import day2.Q4.CommissionEmployee;
import day2.Q4.Employee;

public class Q5 {
    public static void main(String[] args) {
        Employee e=new CommissionEmployee("Rahul",500,40);
        Invoice i=new Invoice("Engine",4,"Car engine",40000);
        System.out.println(i.getPayment());
    }
}
