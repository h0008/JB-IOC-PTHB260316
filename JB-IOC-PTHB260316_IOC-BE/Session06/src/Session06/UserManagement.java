package Session06;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.regex.Pattern;

class User {
    private String fullName;
    private String email;
    private String phone;
    private String password;

    public User(String fullName, String email, String phone, String password) {
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }
    public String getFullName() { return fullName; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getPassword() { return password; }
    @Override
    public String toString() {
        return "User{Name='" + fullName + "', Email='" + email + "', Phone='" +
               phone + "', Password='" + password + "'}";
    }
}

public class UserManagement {
    private ArrayList<User> users;

    public UserManagement() {
        users = new ArrayList<>();
    }

    // 1. Enter user information
    public void enterUserInfo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter full name: ");
        String fullName = scanner.nextLine().trim();
        if (!isValidName(fullName)) {
            System.out.println("Invalid name format! Name should contain only letters and spaces.");
            return;
        }
        System.out.print("Enter email: ");
        String email = scanner.nextLine().trim();
        if (!isValidEmail(email)) {
            System.out.println("Invalid email format!");
            return;
        }
        System.out.print("Enter phone (Vietnamese format): ");
        String phone = scanner.nextLine().trim();
        if (!isValidPhone(phone)) {
            System.out.println("Invalid phone format! Use Vietnamese mobile format (10 digits starting with 0).");
            return;
        }
        System.out.print("Enter password: ");
        String password = scanner.nextLine().trim();
        if (!isValidPassword(password)) {
            System.out.println("Invalid password! Min 8 chars with uppercase, lowercase, digits, and special characters.");
            return;
        }
        users.add(new User(fullName, email, phone, password));
        System.out.println("User added successfully!");
    }
    // 2. Check name format is standard
    public void checkNameFormat() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name to check: ");
        String name = scanner.nextLine().trim();
        if (isValidName(name)) {
            System.out.println("Name format is valid.");
        } else {
            System.out.println("Name format is invalid! Name should contain only letters and spaces.");
        }
    }
    // 3. Check email format is valid
    public void checkEmailFormat() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter email to check: ");
        String email = scanner.nextLine().trim();
        if (isValidEmail(email)) {
            System.out.println("Email format is valid.");
        } else {
            System.out.println("Email format is invalid!");
        }
    }
    // 4. Check phone format is valid
    public void checkPhoneFormat() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter phone to check: ");
        String phone = scanner.nextLine().trim();
        if (isValidPhone(phone)) {
            System.out.println("Phone format is valid.");
        } else {
            System.out.println("Phone format is invalid! Use Vietnamese mobile format.");
        }
    }
    // 5. Check password format is good
    public void checkPasswordFormat() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter password to check: ");
        String password = scanner.nextLine().trim();
        if (isValidPassword(password)) {
            System.out.println("Password format is valid.");
        } else {
            System.out.println("Password format is invalid! Must have min 8 chars with uppercase, lowercase, digits, and special characters.");
        }
    }
    // Validate name: only letters and spaces
    private boolean isValidName(String name) {
        String regex = "^[a-zA-Z\\s]+$";
        return Pattern.matches(regex, name) && name.length() > 0;
    }
    // Validate email: standard email format
    private boolean isValidEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        return Pattern.matches(regex, email);
    }
    // Validate phone: Vietnamese mobile format (10 digits, starts with 0)
    private boolean isValidPhone(String phone) {
        String regex = "^0[0-9]{9}$";
        return Pattern.matches(regex, phone);
    }
    // Validate password: min 8 chars, uppercase, lowercase, digit, special char
    private boolean isValidPassword(String password) {
        if (password.length() < 8) {
            return false;
        }
        boolean hasUppercase = Pattern.compile("[A-Z]").matcher(password).find();
        boolean hasLowercase = Pattern.compile("[a-z]").matcher(password).find();
        boolean hasDigit = Pattern.compile("[0-9]").matcher(password).find();
        boolean hasSpecial = Pattern.compile("[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>?]").matcher(password).find();
        return hasUppercase && hasLowercase && hasDigit && hasSpecial;
    }    // Display all users
    public void displayUsers() {
        if (users.isEmpty()) {
            System.out.println("No users found!");
            return;
        }
        System.out.println("========== USER LIST ==========");
        for (int i = 0; i < users.size(); i++) {
            System.out.println((i + 1) + ". " + users.get(i));
        }
        System.out.println("===============================");
    }
    // Display menu
    public void displayMenu() {
        System.out.println("================= USER MANAGEMENT MENU =================");
        System.out.println("1. Enter user information");
        System.out.println("2. Check name format is standard");
        System.out.println("3. Check email format is valid");
        System.out.println("4. Check phone format is valid");
        System.out.println("5. Check password format is good");
        System.out.println("6. Display all users");
        System.out.println("7. Exit");
        System.out.println("========================================================");
    }

    // Run the program
    public void run() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            displayMenu();
            System.out.print("Choose an option (1-7): ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    enterUserInfo();
                    break;
                case 2:
                    checkNameFormat();
                    break;
                case 3:
                    checkEmailFormat();
                    break;
                case 4:
                    checkPhoneFormat();
                    break;
                case 5:
                    checkPasswordFormat();
                    break;
                case 6:
                    displayUsers();
                    break;
                case 7:
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option! Please enter a number between 1 and 7.");
            }
        } while (choice != 7);
    }
}
