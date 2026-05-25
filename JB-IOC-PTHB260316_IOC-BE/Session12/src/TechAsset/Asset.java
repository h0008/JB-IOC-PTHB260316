package techasset;

import java.util.Scanner;

public abstract class Asset {
    protected String assetCode;
    protected String name;
    protected double purchasePrice;
    protected int yearsUsed;

    public Asset() {}

    public Asset(String assetCode, String name, double purchasePrice, int yearsUsed) {
        this.assetCode = assetCode;
        this.name = name;
        this.purchasePrice = purchasePrice;
        this.yearsUsed = yearsUsed;
    }

    public String getAssetCode() { return assetCode; }
    public void setAssetCode(String assetCode) { this.assetCode = assetCode; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public double getPurchasePrice() { return purchasePrice; }
    public void setPurchasePrice(double purchasePrice) { this.purchasePrice = purchasePrice; }
    public int getYearsUsed() { return yearsUsed; }
    public void setYearsUsed(int yearsUsed) { this.yearsUsed = yearsUsed; }

    public abstract double getMarketValue();

    public void inputInfo(Scanner scanner) {
        System.out.print("Enter Asset Code: ");
        this.assetCode = scanner.nextLine();
        System.out.print("Enter Asset Name: ");
        this.name = scanner.nextLine();

        System.out.print("Enter Purchase Price: ");
        while (true) {
            try {
                this.purchasePrice = Double.parseDouble(scanner.nextLine());
                if (this.purchasePrice < 0) throw new NumberFormatException();
                break;
            } catch (NumberFormatException e) {
                System.out.print("Invalid price. Enter again: ");
            }
        }

        System.out.print("Enter Years Used: ");
        while (true) {
            try {
                this.yearsUsed = Integer.parseInt(scanner.nextLine());
                if (this.yearsUsed < 0) throw new NumberFormatException();
                break;
            } catch (NumberFormatException e) {
                System.out.print("Invalid years. Enter again: ");
            }
        }
    }

    public void displayInfo() {
        System.out.printf("Code: %s | Name: %s | Original Price: %.2f | Years Used: %d",
                assetCode, name, purchasePrice, yearsUsed);
    }
}

