package educareer;

import java.util.Scanner;

public class AdminStaff extends Staff {
    private double bonus;

    public AdminStaff() {}

    public AdminStaff(String id, String name, double baseSalary, double bonus) {
        super(id, name, baseSalary);
        this.bonus = bonus;
    }

    public double getBonus() { return bonus; }
    public void setBonus(double bonus) { this.bonus = bonus; }

    @Override
    public double calculateTotalSalary() {
        return baseSalary + bonus;
    }

    @Override
    public void inputInfo(Scanner scanner) {
        super.inputInfo(scanner);
        System.out.print("Enter Bonus: ");
        while (true) {
            try {
                this.bonus = Double.parseDouble(scanner.nextLine());
                if (this.bonus < 0) throw new NumberFormatException();
                break;
            } catch (NumberFormatException e) {
                System.out.print("Invalid bonus. Enter again: ");
            }
        }
    }

    @Override
    public void displayInfo() {
        System.out.print("[Admin Staff] ");
        super.displayInfo();
    }

    @Override
    public void checkPerformance() {
        if (bonus > 500000) {
            System.out.println("Performance: Outstanding (High bonus)");
        } else {
            System.out.println("Performance: Average");
        }
    }
}

