package techasset;

import java.util.Scanner;

public class NetworkDevice extends Asset {
    private int numberOfPorts;

    public NetworkDevice() {}

    public NetworkDevice(String assetCode, String name, double purchasePrice, int yearsUsed, int numberOfPorts) {
        super(assetCode, name, purchasePrice, yearsUsed);
        this.numberOfPorts = numberOfPorts;
    }

    public int getNumberOfPorts() { return numberOfPorts; }
    public void setNumberOfPorts(int numberOfPorts) { this.numberOfPorts = numberOfPorts; }

    @Override
    public double getMarketValue() {
        // Depreciates at 10% per year linearly
        double value = purchasePrice * (1.0 - 0.10 * yearsUsed);
        return Math.max(0, value);
    }

    @Override
    public void inputInfo(Scanner scanner) {
        super.inputInfo(scanner);
        System.out.print("Enter Number of Ports: ");
        while (true) {
            try {
                this.numberOfPorts = Integer.parseInt(scanner.nextLine());
                if (this.numberOfPorts < 0) throw new NumberFormatException();
                break;
            } catch (NumberFormatException e) {
                System.out.print("Invalid ports number. Enter again: ");
            }
        }
    }

    @Override
    public void displayInfo() {
        System.out.print("[Network Device] ");
        super.displayInfo();
        System.out.printf(" | Ports: %d\n", numberOfPorts);
    }
}

