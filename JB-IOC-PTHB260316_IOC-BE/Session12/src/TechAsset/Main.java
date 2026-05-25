package techasset;

import java.util.Scanner;

public class Main {
    private static Asset[] assets = new Asset[100];
    private static int currLength = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- TechAsset Management ---");
            System.out.println("1. Enter Asset");
            System.out.println("2. Generate Report");
            System.out.println("3. Search Asset by Code");
            System.out.println("4. Search Asset by Min Price");
            System.out.println("5. Edit Purchase Price");
            System.out.println("6. Exit");
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
                    addAsset();
                    break;
                case 2:
                    generateReport();
                    break;
                case 3:
                    System.out.print("Enter Asset Code to search: ");
                    String code = scanner.nextLine();
                    searchAsset(code);
                    break;
                case 4:
                    System.out.print("Enter Minimum Purchase Price: ");
                    try {
                        double price = Double.parseDouble(scanner.nextLine());
                        searchAsset(price);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid price.");
                    }
                    break;
                case 5:
                    editPurchasePrice();
                    break;
                case 6:
                    System.out.println("Exiting the program...");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void addAsset() {
        if (currLength >= assets.length) {
            System.out.println("Storage is full.");
            return;
        }

        System.out.println("1. Add Computer");
        System.out.println("2. Add Network Device");
        System.out.print("Choose type: ");
        int type = -1;
        try {
            type = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input.");
            return;
        }

        Asset a = null;
        if (type == 1) {
            a = new Computer();
        } else if (type == 2) {
            a = new NetworkDevice();
        } else {
            System.out.println("Invalid asset type.");
            return;
        }

        a.inputInfo(scanner);
        assets[currLength] = a;
        currLength++;
        System.out.println("Asset added successfully.");
    }

    public static void showValue(Asset a) {
        System.out.printf("Asset '%s' Current Market Value: %.2f\n", a.getName(), a.getMarketValue());
    }

    private static void generateReport() {
        if (currLength == 0) {
            System.out.println("No assets found.");
            return;
        }
        for (int i = 0; i < currLength; i++) {
            assets[i].displayInfo();
            showValue(assets[i]);
            System.out.println("---------------------");
        }
    }

    // Overloading: Search by code
    private static void searchAsset(String assetCode) {
        boolean found = false;
        for (int i = 0; i < currLength; i++) {
            if (assets[i].getAssetCode().equalsIgnoreCase(assetCode)) {
                assets[i].displayInfo();
                showValue(assets[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Asset not found.");
        }
    }

    // Overloading: Search by minimum purchase price
    private static void searchAsset(double minPrice) {
        boolean found = false;
        for (int i = 0; i < currLength; i++) {
            if (assets[i].getPurchasePrice() > minPrice) {
                assets[i].displayInfo();
                showValue(assets[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No assets found with a purchase price greater than " + minPrice);
        }
    }

    private static void editPurchasePrice() {
        System.out.print("Enter Asset Code to update price: ");
        String code = scanner.nextLine();
        boolean found = false;

        for (int i = 0; i < currLength; i++) {
            if (assets[i].getAssetCode().equalsIgnoreCase(code)) {
                System.out.print("Enter new Purchase Price: ");
                try {
                    double newPrice = Double.parseDouble(scanner.nextLine());
                    if (newPrice < 0) throw new NumberFormatException();
                    assets[i].setPurchasePrice(newPrice);
                    System.out.println("Price updated successfully.");
                } catch (NumberFormatException e) {
                    System.out.println("Invalid price.");
                }
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Asset not found.");
        }
    }
}

