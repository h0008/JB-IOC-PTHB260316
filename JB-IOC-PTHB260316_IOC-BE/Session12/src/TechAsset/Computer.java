package techasset;

import java.util.Scanner;

public class Computer extends Asset {
    private String ram;
    private String cpu;

    public Computer() {}

    public Computer(String assetCode, String name, double purchasePrice, int yearsUsed, String ram, String cpu) {
        super(assetCode, name, purchasePrice, yearsUsed);
        this.ram = ram;
        this.cpu = cpu;
    }

    public String getRam() { return ram; }
    public void setRam(String ram) { this.ram = ram; }
    public String getCpu() { return cpu; }
    public void setCpu(String cpu) { this.cpu = cpu; }

    @Override
    public double getMarketValue() {
        // Depreciates at 20% per year linearly
        double value = purchasePrice * (1.0 - 0.20 * yearsUsed);
        return Math.max(0, value);
    }

    @Override
    public void inputInfo(Scanner scanner) {
        super.inputInfo(scanner);
        System.out.print("Enter RAM: ");
        this.ram = scanner.nextLine();
        System.out.print("Enter CPU: ");
        this.cpu = scanner.nextLine();
    }

    @Override
    public void displayInfo() {
        System.out.print("[Computer] ");
        super.displayInfo();
        System.out.printf(" | RAM: %s | CPU: %s\n", ram, cpu);
    }
}

