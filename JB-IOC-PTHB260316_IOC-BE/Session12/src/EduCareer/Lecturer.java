package educareer;

import java.util.Scanner;

public class Lecturer extends Staff {
    private int teachingHours;

    public Lecturer() {}

    public Lecturer(String id, String name, double baseSalary, int teachingHours) {
        super(id, name, baseSalary);
        this.teachingHours = teachingHours;
    }

    public int getTeachingHours() { return teachingHours; }
    public void setTeachingHours(int teachingHours) { this.teachingHours = teachingHours; }

    @Override
    public double calculateTotalSalary() {
        return baseSalary + (teachingHours * 200000.0);
    }

    @Override
    public void inputInfo(Scanner scanner) {
        super.inputInfo(scanner);
        System.out.print("Enter Teaching Hours: ");
        while (true) {
            try {
                this.teachingHours = Integer.parseInt(scanner.nextLine());
                if (this.teachingHours < 0) throw new NumberFormatException();
                break;
            } catch (NumberFormatException e) {
                System.out.print("Invalid teaching hours. Enter again: ");
            }
        }
    }

    @Override
    public void displayInfo() {
        System.out.print("[Lecturer] ");
        super.displayInfo();
    }

    @Override
    public void checkPerformance() {
        if (teachingHours >= 40) {
            System.out.println("Performance: Excellent (High teaching hours)");
        } else {
            System.out.println("Performance: Normal");
        }
    }
}

