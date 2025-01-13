package day3n4.Q6;

import java.util.Scanner;

public class Q6 {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter name :");
            String name = sc.nextLine();
            System.out.print("Enter age :");
            int age = sc.nextInt();
            if (age<18 || age>60){
                throw new InvalidAgeException("Age must between 18 and 60");
            }
        } catch (InvalidAgeException e) {
            System.out.println(e.getMessage());
        }
    }
}