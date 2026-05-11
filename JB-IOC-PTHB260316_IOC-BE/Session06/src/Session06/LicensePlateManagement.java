package Session06;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

class LicensePlate {
    private String plate;
    public LicensePlate(String plate) {
        this.plate = plate;
    }
    public String getPlate() { return plate; }
    public String getProvincialCode() { return plate.substring(0, 2); }
    @Override
    public String toString() { return plate; }
}

public class LicensePlateManagement {
    private ArrayList<LicensePlate> plates;
    private Map<String, String> provincialCodes;
    public LicensePlateManagement() {
        plates = new ArrayList<>();
        provincialCodes = new HashMap<>();
        initProvinces();
    }
    // Initialize Vietnamese provincial codes
    private void initProvinces() {
        provincialCodes.put("29", "Hanoi");
        provincialCodes.put("30", "Hanoi");
        provincialCodes.put("51", "Ho Chi Minh City");
        provincialCodes.put("52", "Ho Chi Minh City");
        provincialCodes.put("16", "Thai Binh");
        provincialCodes.put("18", "Ha Nam");
        provincialCodes.put("19", "Nam Dinh");
        provincialCodes.put("20", "Ha Giang");
        provincialCodes.put("21", "Cao Bang");
        provincialCodes.put("22", "Bac Kan");
        provincialCodes.put("23", "Lao Cai");
        provincialCodes.put("24", "Yen Bai");
        provincialCodes.put("25", "Tuyen Quang");
        provincialCodes.put("26", "Phu Tho");
        provincialCodes.put("27", "Vinh Phuc");
        provincialCodes.put("28", "Bac Ninh");
        provincialCodes.put("31", "Hai Phong");
        provincialCodes.put("32", "Quang Ninh");
        provincialCodes.put("33", "Ha Tinh");
        provincialCodes.put("34", "Nghe An");
        provincialCodes.put("35", "Thanh Hoa");
        provincialCodes.put("36", "Ha Tinh");
        provincialCodes.put("37", "Quang Binh");
        provincialCodes.put("38", "Quang Tri");
        provincialCodes.put("40", "Thua Thien Hue");
        provincialCodes.put("41", "Da Nang");
        provincialCodes.put("42", "Quang Nam");
        provincialCodes.put("43", "Quang Ngai");
        provincialCodes.put("44", "Binh Dinh");
        provincialCodes.put("45", "Phu Yen");
        provincialCodes.put("47", "Khanh Hoa");
        provincialCodes.put("48", "Ninh Thuan");
        provincialCodes.put("49", "Binh Thuan");
        provincialCodes.put("50", "Dong Nai");
        provincialCodes.put("53", "Ba Ria Vung Tau");
        provincialCodes.put("61", "Dong Thap");
        provincialCodes.put("62", "Long An");
        provincialCodes.put("63", "Tien Giang");
        provincialCodes.put("64", "Ben Tre");
        provincialCodes.put("65", "Vinh Long");
        provincialCodes.put("66", "Can Tho");
        provincialCodes.put("67", "Hau Giang");
        provincialCodes.put("68", "Soc Trang");
        provincialCodes.put("69", "Bac Lieu");
        provincialCodes.put("70", "Ca Mau");
        provincialCodes.put("71", "An Giang");
        provincialCodes.put("72", "Kien Giang");
    }
    // 1. Add license plates
    public void addLicensePlate() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter license plate (format XX(Letter)-XXX.XX, e.g., 30F-123.45): ");
        String plate = scanner.nextLine().trim().toUpperCase();
        if (!isValidLicensePlate(plate)) {
            System.out.println("Invalid license plate format!");
            return;
        }
        plates.add(new LicensePlate(plate));
        System.out.println("License plate added successfully!");
    }
    // 2. Display list of license plates
    public void displayLicensePlates() {
        if (plates.isEmpty()) {
            System.out.println("No license plates found!");
            return;
        }
        System.out.println("========== LICENSE PLATE LIST ==========");
        for (int i = 0; i < plates.size(); i++) {
            String provincial = provincialCodes.getOrDefault(plates.get(i).getProvincialCode(), "Unknown");
            System.out.println((i + 1) + ". " + plates.get(i).getPlate() + " (" + provincial + ")");
        }
        System.out.println("=======================================");
    }
    // 3. Search for license plate (exact match)
    public void searchLicensePlate() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter license plate to search: ");
        String searchPlate = scanner.nextLine().trim().toUpperCase();
        boolean found = false;
        for (LicensePlate plate : plates) {
            if (plate.getPlate().equals(searchPlate)) {
                String provincial = provincialCodes.getOrDefault(plate.getProvincialCode(), "Unknown");
                System.out.println("Found: " + plate.getPlate() + " (" + provincial + ")");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("License plate not found!");
        }
    }
    // 4. Find license plates by provincial code
    public void findByProvincialCode() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter provincial code (e.g., 30 for Hanoi, 51 for HCM): ");
        String code = scanner.nextLine().trim();
        ArrayList<LicensePlate> result = new ArrayList<>();
        for (LicensePlate plate : plates) {
            if (plate.getProvincialCode().equals(code)) {
                result.add(plate);
            }
        }
        if (result.isEmpty()) {
            System.out.println("No license plates found for provincial code: " + code);
            return;
        }
        String provinceName = provincialCodes.getOrDefault(code, "Unknown Province");
        System.out.println("License plates in " + provinceName + " (Code: " + code + "):");
        for (int i = 0; i < result.size(); i++) {
            System.out.println((i + 1) + ". " + result.get(i).getPlate());
        }
    }
    // 5. Sort license plates in ascending order (bubble sort)
    public void sortLicensePlates() {
        if (plates.isEmpty()) {
            System.out.println("No license plates to sort!");
            return;
        }
        ArrayList<LicensePlate> temp = new ArrayList<>(plates);
        for (int i = 0; i < temp.size() - 1; i++) {
            for (int j = 0; j < temp.size() - i - 1; j++) {
                if (temp.get(j).getPlate().compareTo(temp.get(j + 1).getPlate()) > 0) {
                    LicensePlate swap = temp.get(j);
                    temp.set(j, temp.get(j + 1));
                    temp.set(j + 1, swap);
                }
            }
        }
        System.out.println("========== SORTED LICENSE PLATES ==========");
        for (int i = 0; i < temp.size(); i++) {
            System.out.println((i + 1) + ". " + temp.get(i).getPlate());
        }
        System.out.println("==========================================");
    }
    // Validate license plate format: XX(Letter)-XXX.XX
    private boolean isValidLicensePlate(String plate) {
        String regex = "^[0-9]{2}[A-Z]-[0-9]{3}\\.[0-9]{2}$";
        return Pattern.matches(regex, plate);
    }
    // Display menu
    public void displayMenu() {
        System.out.println("================= LICENSE PLATE MANAGEMENT MENU =================");
        System.out.println("1. Add license plates");
        System.out.println("2. Display list of license plates");
        System.out.println("3. Search for license plate");
        System.out.println("4. Find license plates by provincial code");
        System.out.println("5. Sort license plates in ascending order");
        System.out.println("6. Exit");
        System.out.println("==================================================================");
    }

    // Run the program
    public void run() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            displayMenu();
            System.out.print("Choose an option (1-6): ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    addLicensePlate();
                    break;
                case 2:
                    displayLicensePlates();
                    break;
                case 3:
                    searchLicensePlate();
                    break;
                case 4:
                    findByProvincialCode();
                    break;
                case 5:
                    sortLicensePlates();
                    break;
                case 6:
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option! Please enter a number between 1 and 6.");
            }
        } while (choice != 6);
    }
}
