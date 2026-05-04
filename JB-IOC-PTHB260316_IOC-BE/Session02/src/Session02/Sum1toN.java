package Session02;

import java.util.Scanner;

public class Sum1toN {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a positive integer N: ");
        int n = input.nextInt();
        if (n <= 0) {
            System.out.println("Invalid number entered");
            return; // Exit the program if the input is invalid
        }
        else {
            int sum = 0;
            for (int i = 1; i <= n; i++) {
                sum += i; // Add each value from 1 to N to the sum
            }
            System.out.println("The sum of numbers from 1 to " + n + " is: " + sum);
        }
    }
}
