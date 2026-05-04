package Session02;

import java.util.Scanner;
public class SumOfDigitsInteger {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int number = input.nextInt();
        if (number < 0) {
            System.out.println("Invalid number entered");
            return;
        }
        else {
            int sumOfDigits = 0;
            while (number > 0) {
                sumOfDigits += number % 10;
                number /= 10;
            }
            System.out.println("The sum of the digits is: " + sumOfDigits);
        }
    }
}
