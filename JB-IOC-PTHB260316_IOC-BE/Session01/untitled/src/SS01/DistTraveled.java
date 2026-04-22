package SS01;

import java.util.Scanner;
public class DistTraveled {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the velocity (km/h): ");
        float velocity = input.nextFloat();
        if (velocity < 0) {
            System.out.println("Velocity must be greater than or equal to 0.");
            return;
        }
        System.out.print("Enter the time traveled (h): ");
        float time = input.nextFloat();

        if (time < 0) {
            System.out.println("Time must be greater than or equal to 0.");
        }
        float dist = velocity * time;
        System.out.printf("The distance traveled is: %.2f km", dist);
    }
}
