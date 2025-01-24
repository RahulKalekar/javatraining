package day2.Q5;

public class Invoice implements Payable{
    private String partNum;
    private String partDescription;
    private int quantity;
    private double pricePerItem;

    public Invoice(String partNum, int quantity, String partDescription, double pricePerItem) {
        this.partNum = partNum;
        this.quantity = quantity;
        this.partDescription = partDescription;
        this.pricePerItem = pricePerItem;
    }

    public String getPartNum() {
        return partNum;
    }

    public void setPartNum(String partNum) {
        this.partNum = partNum;
    }

    public double getPricePerItem() {
        return pricePerItem;
    }

    public void setPricePerItem(double pricePerItem) {
        this.pricePerItem = pricePerItem;
    }

    public String getPartDescription() {
        return partDescription;
    }

    public void setPartDescription(String partDescription) {
        this.partDescription = partDescription;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPayment(){
        return quantity*pricePerItem;
    }
}
