package SS01;

import java.util.Scanner;
public class ArithmeticOp {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        int num1 = in.nextInt();
        System.out.print("Enter the second number: ");
        int num2 = in.nextInt();
        // Arithmetic operations to be done: +; -; x; /; % (mod)
        int Sum = num1 + num2;
        int Sub = num1 - num2;
        int Mult = num1 * num2;
        int Div = num1 / num2;
        int Mod = num1 % num2;
        System.out.println("The first number is: " + num1);
        System.out.println("The second number is: " + num2);
        System.out.println("The sum is: " + Sum);
        System.out.println("The subtraction is: " + Sub);
        System.out.println("The multiplication is: " + Mult);
        System.out.println("The division is: " + Div);
        System.out.println("The modulus is: " + Mod);
    }
}
