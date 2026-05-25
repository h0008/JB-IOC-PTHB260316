package PaymentSystem;

public abstract class Payment {
    private double amount;

    public Payment(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public abstract void pay();

    public void printAmount() {
        System.out.println("Payment Amount: $" + amount);
    }
}

