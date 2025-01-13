package day3n4.Q7;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Q7 {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter 1st number: ");
            int num1 = sc.nextInt();
            System.out.print("Enter 2nd number: ");
            int num2 = sc.nextInt();
            System.out.println("The quotient of " + num1 + "/ " + num2 + " is: " + num1 / num2);
        } catch (ArithmeticException e) {
            System.out.println("DivideByZeroException caught");
        } catch (InputMismatchException e) {
            System.out.println("InputMismatchException caught");
        }
        finally {
            System.out.println("finally block part");
        }

    }
}