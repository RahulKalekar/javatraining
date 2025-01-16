package day6.Q2;

public class Account {
    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void addAmount(double amount) {
        balance += amount;
    }
    public void subtractAmount(double amount) {
        balance -= amount;
    }


}