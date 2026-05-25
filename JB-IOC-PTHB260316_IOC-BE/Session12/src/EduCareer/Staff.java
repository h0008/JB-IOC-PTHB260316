package educareer;

import java.util.Scanner;

public abstract class Staff implements ICapability {
    protected String id;
    protected String name;
    protected double baseSalary;

    public Staff() {}

    public Staff(String id, String name, double baseSalary) {
        this.id = id;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public double getBaseSalary() { return baseSalary; }
    public void setBaseSalary(double baseSalary) { this.baseSalary = baseSalary; }

    public abstract double calculateTotalSalary();

    public void inputInfo(Scanner scanner) {
        System.out.print("Enter ID: ");
        this.id = scanner.nextLine();
        System.out.print("Enter Name: ");
        this.name = scanner.nextLine();
        System.out.print("Enter Base Salary: ");
        while (true) {
            try {
                this.baseSalary = Double.parseDouble(scanner.nextLine());
                if (this.baseSalary < 0) throw new NumberFormatException();
                break;
            } catch (NumberFormatException e) {
                System.out.print("Invalid salary. Enter again: ");
            }
        }
    }

    public void displayInfo() {
        System.out.printf("ID: %s | Name: %s | Base Salary: %.2f | Total Salary (including allowance): %.2f\n",
            id, name, baseSalary, calculateTotalSalary());
    }
}

