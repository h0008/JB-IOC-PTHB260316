package EmployeeManagement;

public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[2];
        employees[0] = new FullTimeEmployee(1, "Alice Smith", 5000.0);
        employees[1] = new PartTimeEmployee(2, "Bob Jones", 120, 20.0);

        for (Employee emp : employees) {
            emp.showInfo();
            System.out.println("Salary: $" + emp.calculateSalary());

            if (emp instanceof BonusEligible) {
                BonusEligible eligibleEmp = (BonusEligible) emp;
                System.out.println("Bonus: $" + eligibleEmp.calculateBonus());
            } else {
                System.out.println("No reward");
            }
            System.out.println("---------------------------------");
        }
    }
}

