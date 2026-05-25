package educareer;

import java.util.Scanner;

public class Main {
    private static Staff[] staffs = new Staff[100];
    private static int currLength = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- EduCareer HR Management ---");
            System.out.println("1. Add New Employee");
            System.out.println("2. Display List");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = -1;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    displayEmployees();
                    break;
                case 3:
                    updateEmployee();
                    break;
                case 4:
                    deleteEmployee();
                    break;
                case 5:
                    System.out.println("Exiting the program...");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void addEmployee() {
        if (currLength >= staffs.length) {
            System.out.println("The employee array is full.");
            return;
        }

        System.out.println("1. Add Lecturer");
        System.out.println("2. Add Admin Staff");
        System.out.print("Choose type: ");
        int type = -1;
        try {
            type = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input.");
            return;
        }

        Staff s = null;
        if (type == 1) {
            s = new Lecturer();
        } else if (type == 2) {
            s = new AdminStaff();
        } else {
            System.out.println("Invalid employee type.");
            return;
        }

        s.inputInfo(scanner);
        staffs[currLength] = s;
        currLength++;
        System.out.println("Employee added successfully.");
    }

    private static void displayEmployees() {
        if (currLength == 0) {
            System.out.println("No employees found.");
            return;
        }
        for (int i = 0; i < currLength; i++) {
            staffs[i].displayInfo();
            staffs[i].checkPerformance();
        }
    }

    private static int findEmployeeById(String id) {
        for (int i = 0; i < currLength; i++) {
            if (staffs[i].getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    private static void updateEmployee() {
        System.out.print("Enter Employee ID to update: ");
        String idInfo = scanner.nextLine();
        int index = findEmployeeById(idInfo);

        if (index == -1) {
            System.out.println("Employee not found.");
            return;
        }

        System.out.println("Enter new details:");
        staffs[index].inputInfo(scanner);
        System.out.println("Employee updated successfully.");
    }

    private static void deleteEmployee() {
        System.out.print("Enter Employee ID to delete: ");
        String idInfo = scanner.nextLine();
        int index = findEmployeeById(idInfo);

        if (index == -1) {
            System.out.println("Employee not found.");
            return;
        }

        for (int i = index; i < currLength - 1; i++) {
            staffs[i] = staffs[i + 1];
        }
        staffs[currLength - 1] = null;
        currLength--;
        System.out.println("Employee deleted successfully.");
    }
}

