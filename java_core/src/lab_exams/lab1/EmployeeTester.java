package lab_exams.lab1;

import java.io.*;

public class EmployeeTester {
    private static Employee employee=new Employee("RAhul","rahul123");

    public static void main(String[] args) throws IOException {
        System.out.println(employee.toString());
        try(ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream("data.ser"))) {
            out.writeObject(employee);
            System.out.println("serialized and created a file with .ser");
        } catch (IOException e) {
            e.printStackTrace();
        } ;

        Employee employee1=new Employee();

        try(ObjectInputStream in=new ObjectInputStream((new FileInputStream("data.ser")))){
            employee1= (Employee) in.readObject();
            System.out.println("deserialization success");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(employee1.toString());
    }

}
