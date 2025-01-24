package day1;
/*
Write a program called Fibonacci to display the first 20 Fibonacci numbers F(n), where
F(n)=F(n–1)+F(n–2) and F(1)=F(2)=1. Also compute their average. The output shall look like
 */

import java.util.Scanner;

public class Fibonnaci {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter how many fibonnaci numbers needed");
        int n=scanner.nextInt();
        int n1=1,n2=1,n3,sum=0;
        int number=n;
        while(n!=0){
            System.out.println(" "+n1);
            sum=sum+n1;
            n3=n1+n2;
            n1=n2;
            n2=n3;
            n--;
        }
        System.out.println("Average is"+ sum/number);
    }
}
