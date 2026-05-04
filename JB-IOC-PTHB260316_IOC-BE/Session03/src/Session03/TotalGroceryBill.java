package Session03;

import java.util.Scanner;
import java.text.DecimalFormat;

public class TotalGroceryBill {
    static void main() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Customer name: ");
        String customerName = scanner.nextLine();
        System.out.print("Product: ");
        String productName = scanner.nextLine();
        System.out.print("Price: ");
        double price = Double.parseDouble(scanner.nextLine().replace(".", ""));
        System.out.print("Quantity: ");
        int quantity = Integer.parseInt(scanner.nextLine());
        System.out.print("Membership card (true/false): ");
        boolean hasMembership = Boolean.parseBoolean(scanner.nextLine());
        // Calculation
        double amount = price * quantity;
        double discount = hasMembership ? (amount * 0.10) : 0;
        double vat = amount * 0.08;
        double totalPayment = amount - discount + vat;
        DecimalFormat formatter = new DecimalFormat("#,###");
        // Print bill
        System.out.println("\nCustomer: " + customerName);
        System.out.println("Product: " + productName);
        System.out.println("Price: " + formatter.format(price).replace(",", ".") + " VND");
        System.out.println("Quantity: " + quantity);
        System.out.println("Total Amount: " + formatter.format(amount).replace(",", ".") + " VND");
        System.out.println("Discount: " + formatter.format(discount).replace(",", "."));
        System.out.println("VAT: " + formatter.format(vat).replace(",", "."));
        System.out.println("Total Payment: " + formatter.format(totalPayment).replace(",", ".") + " VND");
    }
}
