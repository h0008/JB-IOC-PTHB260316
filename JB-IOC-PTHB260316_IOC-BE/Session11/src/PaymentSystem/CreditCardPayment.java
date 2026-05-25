package PaymentSystem;

public class CreditCardPayment extends Payment implements Refundable {
    public CreditCardPayment(double amount) {
        super(amount);
    }

    @Override
    public void pay() {
        System.out.println("Processing credit card payment of $" + getAmount());
    }

    @Override
    public void refund() {
        System.out.println("Refunding credit card payment of $" + getAmount());
    }
}

