package day2.Q4;
/*Q4. An Employee Record System
You need to implement the Employee records of a company. The Company has 3 types of
employee;
1) Salaried employee-> This type of employees are paid a fixed weekly salary regardless of the number
of hours worked.
2) Hourly employee -> They are paid by the hour. They have an hourly rate and their payment will
depend on how many hours they worked. The more they work, the more they will be paid. So, the
salary will be [hour worked per week* hourly rate].
3) Commission employee-> They are paid a percentage of their sales. If their percentage is “a” and
total weekly sale is ”b”, the total weekly salary will be [a*b/100];
1. Implement the system, where you can get the weekly salary of any employee,
2. The company also wants option to increase the salary of a particular type of employee by a
specific percentage.
3. use Array List to store the list of the employee.
*/
import java.util.ArrayList;
import java.util.Scanner;

public class Q4 {
    public static void main(String[] args){
        ArrayList<Employee> employeeList=new ArrayList<Employee>();     //creation of arraylistt
        Employee e1=new SalariedEmployee("Rahul",10000);
        Employee e2=new CommissionEmployee("Rohan",10000,20);
        Employee e3=new HourlyEmployee("Aniketh",40,500);
        Employee e4=new CommissionEmployee("Shaurya",10000,20);
        employeeList.add(e1);
        employeeList.add(e2);
        employeeList.add(e3);
        employeeList.add(e4);
        System.out.println(employeeList);     //details of all employees
        // 2. The company also wants option to increase the salary of a particular type of employee by a
        //specific percentage.
        System.out.println("To which type of employee should the hike be given 1.Commission 2.Salaried 3.Hourly");
        Scanner scanner=new Scanner(System.in);
        int type= scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter how much hike percentage");
        int percentage=scanner.nextInt();
        System.out.println("Before Hike");
        System.out.println(employeeList);
        System.out.println("After hike");
        switch(type) {
            case 1:
                for (Employee emp : employeeList) {
                    if (emp instanceof CommissionEmployee) {
                        emp.increaseSalary(percentage);
                    }
                }
            case 2:
                for (Employee emp : employeeList) {
                    if (emp instanceof SalariedEmployee) {
                        emp.increaseSalary(percentage);
                    }
                }
            case 3:
                for (Employee emp : employeeList) {
                    if (emp instanceof HourlyEmployee) {
                        emp.increaseSalary(percentage);
                    }
                }
        }
        System.out.println(employeeList);

    }
}
