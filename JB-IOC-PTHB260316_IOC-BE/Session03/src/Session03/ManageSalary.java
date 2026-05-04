package Session03;

import java.util.Scanner;
import java.text.DecimalFormat;

public class ManageSalary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat formatter = new DecimalFormat("#,###.##");

        int employeeCount = 0;
        double totalSalary = 0;
        double highestSalary = -1;
        double lowestSalary = Double.MAX_VALUE;
        double totalBonus = 0;

        while (true) {
            System.out.println("\n--- Salary Management Menu ---");
            System.out.println("1. Enter employee salary");
            System.out.println("2. Display statistics");
            System.out.println("3. Show total bonus");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = 0;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input.");
                continue;
            }

            switch (choice) {
                case 1:
                    while (true) {
                        System.out.print("Enter salary (-1 to stop): ");
                        double salary;
                        try {
                            salary = Double.parseDouble(scanner.nextLine().replace(".", "").replace(",", ""));
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid numeric input.");
                            continue;
                        }

                        if (salary == -1) break;

                        if (salary < 0 || salary > 500_000_000) {
                            System.out.println("Salary must be between 0 and 500,000,000.");
                            continue;
                        }

                        // Classify income and calculate total bonus
                        if (salary < 5_000_000) {
                            System.out.println("Classification: Low income");
                            totalBonus += salary * 0.05;
                        } else if (salary < 15_000_000) {
                            System.out.println("Classification: Middle income");
                            totalBonus += salary * 0.10;
                        } else if (salary < 50_000_000) {
                            System.out.println("Classification: Good income");
                            totalBonus += salary * 0.15;
                        } else if (salary < 100_000_000) {
                            System.out.println("Classification: High income");
                            totalBonus += salary * 0.20;
                        } else {
                            System.out.println("Classification: High income");
                            totalBonus += salary * 0.25;
                        }

                        // Update statistics
                        employeeCount++;
                        totalSalary += salary;
                        if (salary > highestSalary) highestSalary = salary;
                        if (salary < lowestSalary) lowestSalary = salary;
                    }
                    break;
                case 2:
                    if (employeeCount == 0) {
                        System.out.println("There is no data.");
                    } else {
                        System.out.println("Number of employees: " + employeeCount);
                        System.out.println("Average salary: " + formatter.format(totalSalary / employeeCount) + " VND");
                        System.out.println("Highest salary: " + formatter.format(highestSalary) + " VND");
                        System.out.println("Lowest salary: " + formatter.format(lowestSalary) + " VND");
                        System.out.println("Total wages: " + formatter.format(totalSalary) + " VND");
                    }
                    break;
                case 3:
                    if (employeeCount == 0) {
                        System.out.println("There is no data. Total bonus: 0");
                    } else {
                        System.out.println("Total amount of bonuses: " + formatter.format(totalBonus) + " VND");
                    }
                    break;
                case 4:
                    System.out.println("Exiting the program...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please choose 1-4.");
            }
        }
    }
}
