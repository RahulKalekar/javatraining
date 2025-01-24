package day2.Q3;
import java.util.Scanner;
public class Q3 {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Welcome to Koerber Bank");
        System.out.println("Which type of account do you want to open");
        System.out.println("1.Savings 2.Current");
        int type= scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter Name");
        String userName=scanner.nextLine();
        System.out.println("Generating account number...");
        String accnum="1234556";
        System.out.println("Your account number is "+accnum);
        double amount;
        do{
            System.out.println("Enter deposit amount");
            amount= scanner.nextDouble();
        }
        while(amount<1000);
        if(type==1){
        Account account=new SavingsAccount(userName,accnum,amount,5,1000);
            account.deposit(amount);
            System.out.println(account.getAccountBalance());
            System.out.println(account.getName());
        }
        else{
            Account account2=new CurrentAccount(userName,accnum,amount,"345",1000);
            account2.deposit(amount);
            System.out.println(account2.getAccountBalance());
            System.out.println(account2.getName());
        }

    }
}
