package SS01;

import java.util.Scanner;
public class SumOfTwoFrac {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        int num1 = in.nextInt();
        System.out.print("Enter the first denominator: ");
        int den1 = in.nextInt();
        System.out.print("Enter the second number: ");
        int num2 = in.nextInt();
        System.out.print("Enter the second denominator: ");
        int den2 = in.nextInt();

        int sumNum = num1 * den2 + num2 * den1;
        int sumDen = den1 * den2;

        System.out.printf("The sum of %d/%d and %d/%d is: %d/%d", num1, den1, num2, den2, sumNum, sumDen);
    }
}
