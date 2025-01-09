package day2.Q3;

public class SavingsAccount extends Account {
    private double interest=5.0;
    private double maxWithdrawAmount;
    private double minimumBalance;
    public SavingsAccount(String name,String accountNumber,double accountBalance,double interest,double minBalance){
        super(name,accountNumber,accountBalance);
        this.interest=interest;
        this.minimumBalance=minBalance;
        this.maxWithdrawAmount=accountBalance-minimumBalance;
    }
    public double getBalance(){
        return getAccountBalance()*(100+interest)/100;
    }

    public void withdraw(double amount){
        if(amount<=maxWithdrawAmount){
            setAccountBalance(getAccountBalance()-amount);
            System.out.println("amount "+amount+"is withdrawn");
        }
        else{
            System.out.println("Cannot withdraw since min balance needed");
        }

    }
    @Override
    public String toString(){
        return super.toString()+" interest="+interest+", max withdraw limit= "+maxWithdrawAmount+", minimumBalance="+minimumBalance+"]";

    }
}
