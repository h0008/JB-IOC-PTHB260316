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
        String BMIStr = String.format("%.2f", BMI);
        System.out.println("The BMI is: " + BMI);
    }
}
