package day6.Q2;

public class Q2 {

    public static void main(String[] args) {
        Account account = new Account(1000);
        Bank bank = new Bank(account);
        Company company = new Company(account);

        Thread t2 = new Thread(bank);
        Thread t3 = new Thread(company);
        t2.start();
        t3.start();

        try {
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(account.getBalance());
    }
}