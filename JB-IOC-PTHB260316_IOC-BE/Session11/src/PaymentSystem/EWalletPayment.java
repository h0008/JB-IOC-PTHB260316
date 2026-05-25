package PaymentSystem;

public class EWalletPayment extends Payment implements Refundable {
    public EWalletPayment(double amount) {
        super(amount);
    }

    @Override
    public void pay() {
        System.out.println("Processing e-wallet payment of $" + getAmount());
    }

    @Override
    public void refund() {
        System.out.println("Refunding e-wallet payment of $" + getAmount());
    }
}

