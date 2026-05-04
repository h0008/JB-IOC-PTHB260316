package Session02;

import java.util.Scanner;

public class ValidCheckTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first edge: ");
        int a = scanner.nextInt();
        System.out.print("Enter second edge: ");
        int b = scanner.nextInt();
        System.out.print("Enter third edge: ");
        int c = scanner.nextInt();

        if (a <= 0 || b <= 0 || c <= 0) {
            System.out.println("The three sides do not form triangles.");
        } else if (a + b > c && a + c > b && b + c > a) {
            if (a == b && b == c) {
                System.out.println("Even triangle");
            } else if (a == b || b == c || a == c) {
                System.out.println("Isosceles triangle");
            } else if (a * a + b * b == c * c || a * a + c * c == b * b || b * b + c * c == a * a) {
                System.out.println("Right triangle");
            } else {
                System.out.println("Normal triangle");
            }
        } else {
            System.out.println("The three sides do not form triangles.");
        }
    }
}
