package day2.Q3;

public class CurrentAccount extends Account{
    private String tradeLicenceNumber;
    private double overdraft;
    public CurrentAccount(String name,String accountNumber,double accountBalance,String tradeLicenceNumber,double overdraft){
        super(name,accountNumber,accountBalance);
        this.tradeLicenceNumber=tradeLicenceNumber;
        this.overdraft=overdraft;
    }
    public void withdraw(double amount){
        double allowedWithdrawal=getAccountBalance()+overdraft;
        if(allowedWithdrawal<=amount){
            setAccountBalance(getAccountBalance()-amount);
            System.out.println("amount"+amount+"is withdrawn");
        }
        else{
            System.out.println("Cant withdraw insufficient limit");
        }


    }
    @Override
    public String toString(){
        return super.toString()+" trade license number="+tradeLicenceNumber+", overdraft limit= "+overdraft+"]";

    }
}
