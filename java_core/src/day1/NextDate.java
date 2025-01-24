package day1;
//we need to convert into oo way
/*
 * 1. we input from the user, validation
 * enter day: 31
 * enter month: 12
 * enter year: 2022
 *
 * You have entered date: 31/12/2022
 * Next date: 1/1/2023
 */
import java.util.Scanner;

public class NextDate {

    public static void main(String[] args) {

        int day, month, year;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter day");
        day = scanner.nextInt();

        System.out.println("Enter month");
        month = scanner.nextInt();
        System.out.println("Enter year");
        year = scanner.nextInt();

        System.out.println("current date: " + day + "/" + month + "/" + year);


        int noOfDaysInMonth[]={-1, 31,28,31,30,31,30,31,31,30,31,30,31};
        //maintain an array to keep track of days in a month

        if(isLeapYear(year)){
            noOfDaysInMonth[2]=29;
        }
        day=day+1;
        //whatever happens extend the date then check if exceeds 31
        if(day > noOfDaysInMonth[month]){
            day=1;
            month++;
            if(month > 12){
                month=1;
                year++;
            }

        }
        System.out.println("Next date is : " + day + "/" + month + "/" + year);
    }

    public static boolean isLeapYear(int year) {
        if ((year % 4 == 0) && (year % 400 == 0 || year % 100 != 0))
            return true;
        else
            return false;
    }
}