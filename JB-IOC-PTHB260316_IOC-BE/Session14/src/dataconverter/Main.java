package dataconverter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> validIntegers = new ArrayList<>();
        int invalidCount = 0;
        System.out.println("Enter strings to convert to integers (type 'exit' to stop):");
        while (true) {
            String input = scanner.nextLine();
            if ("exit".equalsIgnoreCase(input.trim())) {
                break;
            }
            try {
                int number = Integer.parseInt(input);
                validIntegers.add(number);
            } catch (NumberFormatException e) {
                invalidCount++;
            }
        }
        System.out.println("Number of valid strings: " + validIntegers.size());
        System.out.println("Number of invalid strings: " + invalidCount);
        System.out.println("Successfully converted integers: " + validIntegers);
        scanner.close();
    }
}
