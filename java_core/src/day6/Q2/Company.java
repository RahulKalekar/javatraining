package day6.Q2;

public class Company implements Runnable {
    Account account;

    public Company(Account account){
        this.account = account;
    }

    public synchronized void deposit(double amount){
        account.addAmount(amount);
    }

    public synchronized void withdraw(double amount){
        account.subtractAmount(amount);
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            deposit(1000);;
        }
    }
}
