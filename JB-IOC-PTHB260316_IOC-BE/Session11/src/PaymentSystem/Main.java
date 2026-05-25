package PaymentSystem;

public class Main {
    public static void main(String[] args) {
        Payment[] payments = new Payment[3];
        payments[0] = new CashPayment(50.0);
        payments[1] = new CreditCardPayment(150.0);
        payments[2] = new EWalletPayment(75.5);

        for (Payment payment : payments) {
            payment.printAmount();
            payment.pay();

            if (payment instanceof Refundable) {
                ((Refundable) payment).refund();
            }
            System.out.println();
        }
    }
}

