package primechecker;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        try {
            int number = Integer.parseInt(scanner.nextLine());
            if (number <= 0) {
                System.out.println("The input must be greater than zero to check for primes.");
                return;
            }
            if (isPrime(number)) {
                System.out.println(number + " is a prime number");
            } else {
                System.out.println(number + " is not a prime number");
            }
        } catch (NumberFormatException e) {
            System.out.println("The input is not a valid integer.");
        } finally {
            scanner.close();
        }
    }
    private static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
