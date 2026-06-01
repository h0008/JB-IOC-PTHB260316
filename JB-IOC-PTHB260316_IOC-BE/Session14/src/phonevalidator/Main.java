package phonevalidator;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter phone numbers separated by commas:");
        String input = scanner.nextLine();
        scanner.close();

        String[] phones = input.split(",");
        List<String> validPhones = new ArrayList<>();
        Map<String, String> invalidPhones = new LinkedHashMap<>();

        for (String phoneRaw : phones) {
            String phone = phoneRaw.trim();
            if (phone.isEmpty()) continue;

            try {
                InvalidPhoneNumberLengthException.validatePhoneNumber(phone);
                validPhones.add(phone);
            } catch (InvalidPhoneNumberLengthException e) {
                invalidPhones.put(phone, e.getMessage());
            }
        }

        System.out.println("\nValid phone numbers:");
        for (String vp : validPhones) {
            System.out.println("- " + vp);
        }

        System.out.println("\nInvalid phone numbers:");
        for (Map.Entry<String, String> entry : invalidPhones.entrySet()) {
            System.out.println("- " + entry.getKey() + " : " + entry.getValue());
        }
    }
}

