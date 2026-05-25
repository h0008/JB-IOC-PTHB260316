package EmployeeManagement;

public class FullTimeEmployee extends Employee implements BonusEligible {
    private double baseSalary;

    public FullTimeEmployee(int id, String name, double baseSalary) {
        super(id, name);
        this.baseSalary = baseSalary;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    @Override
    public double calculateSalary() {
        return baseSalary;
    }

    @Override
    public double calculateBonus() {
        return baseSalary * 0.10;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Base Salary: $" + baseSalary);
    }
}

