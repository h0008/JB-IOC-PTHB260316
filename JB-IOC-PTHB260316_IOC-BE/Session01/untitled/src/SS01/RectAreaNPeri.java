package SS01;

import java.util.Scanner;
public class RectAreaNPeri {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the length of the rectangle: ");
        float length = in.nextFloat();
        System.out.print("Enter the width of the rectangle: ");
        float width = in.nextFloat();
        float area = length * width;
        float perimeter = 2 * (length + width);
        System.out.println("The area of the rectangle is: " + area);
        System.out.println("The perimeter of the rectangle is: " + perimeter);
    }
}
