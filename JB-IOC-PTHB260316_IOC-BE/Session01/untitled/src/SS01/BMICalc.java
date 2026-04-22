package SS01;

import java.util.Scanner;
public class BMICalc {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the weight of your body in kg: ");
        float weight = input.nextFloat();
        System.out.print("Enter the weight of your body in meters (eg. 1,75m): ");
        float height = input.nextFloat();
        float BMI = weight / (height * height);
        System.out.printf("The BMI is: %.2f", BMI);
    }
}
