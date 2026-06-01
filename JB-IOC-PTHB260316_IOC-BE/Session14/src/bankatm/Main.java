package bankatm;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        long balance = 1000000;
        long minBalance = 50000;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Initial balance: 1000000 VND");
        while (true) {
            System.out.println("Enter the amount to withdraw (or 'exit' to stop):");
            String input = scanner.nextLine();
            if ("exit".equalsIgnoreCase(input.trim())) {
                break;
            }
            try {
                long withdrawAmount = Long.parseLong(input);
                if (withdrawAmount <= 0) {
                    System.out.println("Error: Please enter a valid number!");
                    continue;
                }
                if (withdrawAmount > balance) {
                    System.out.println("Error: Withdrawal amount exceeds balance!");
                } else if (balance - withdrawAmount < minBalance) {
                    System.out.println("Error: Account must maintain a minimum balance of 50,000 VND!");
                } else {
                    balance -= withdrawAmount;
                    System.out.println("Amount withdrawn: " + withdrawAmount + " VND");
                    System.out.println("Remaining balance: " + balance + " VND");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid number!");
            }
        }
        scanner.close();
    }
}
