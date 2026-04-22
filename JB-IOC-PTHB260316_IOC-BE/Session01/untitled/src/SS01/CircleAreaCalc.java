package SS01;

import java.util.Scanner;
public class CircleAreaCalc {
    static void main() {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the radius of the circle: ");
        double radius = s.nextDouble();
        double area = 3.14 * radius * radius;
        System.out.printf("The area of the circle with a radius of %.2f is: %.2f", radius, area);
        /* Test cases:
        Radius = 1; 3; 5; 0; 10
        */
    }
}
