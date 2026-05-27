package Session13;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class UserManagement {
    static class Person {
        private String name;
        private String email;
        private String phone;
        public Person() {}
        public Person(String name, String email, String phone) { this.name = name; this.email = email; this.phone = phone; }
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }
        public String getPhone() { return phone; }
        public void setPhone(String phone) { this.phone = phone; }
        @Override public String toString() { return "Name: " + name + ", Email: " + email + ", Phone: " + phone; }
    }

    public interface Manage<T> { void add(T item); void update(int index, T item); void delete(int index); void display(); }

    static class UserManager implements Manage<Person> {
        private final LinkedList<Person> users = new LinkedList<>();
        @Override public void add(Person item) { users.add(item); }
        @Override public void update(int index, Person item) { if (index >= 0 && index < users.size()) users.set(index, item); }
        @Override public void delete(int index) { if (index >= 0 && index < users.size()) users.remove(index); }
        @Override public void display() { if (users.isEmpty()) { System.out.println("No users."); return; } for (Person p : users) System.out.println(p.toString()); }
        public int findIndexByEmail(String email) { for (int i = 0; i < users.size(); i++) if (users.get(i).getEmail().equalsIgnoreCase(email)) return i; return -1; }
        public boolean deleteByEmail(String email) { Iterator<Person> it = users.iterator(); while (it.hasNext()) { if (it.next().getEmail().equalsIgnoreCase(email)) { it.remove(); return true; } } return false; }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserManager manager = new UserManager();
        int choice;
        do {
            System.out.println("\n**************** USER MANAGEMENT MENU ****************");
            System.out.println("1. Add user");
            System.out.println("2. Delete user (by email)");
            System.out.println("3. Display user list");
            System.out.println("4. Exit");
            System.out.print("Your choice: ");
            choice = -1;
            try { choice = Integer.parseInt(scanner.nextLine()); } catch (NumberFormatException e) { System.out.println("Invalid input. Enter a number."); continue; }
            switch (choice) {
                case 1:
                    String name = "";
                    while (name.trim().isEmpty()) { System.out.print("Enter name: "); name = scanner.nextLine(); if (name.trim().isEmpty()) System.out.println("Please do not leave it blank!"); }
                    String email = "";
                    while (email.trim().isEmpty()) { System.out.print("Enter email: "); email = scanner.nextLine(); if (email.trim().isEmpty()) System.out.println("Please do not leave it blank!"); }
                    String phone = "";
                    while (phone.trim().isEmpty()) { System.out.print("Enter phone: "); phone = scanner.nextLine(); if (phone.trim().isEmpty()) System.out.println("Please do not leave it blank!"); }
                    manager.add(new Person(name, email, phone));
                    System.out.println("User added successfully.");
                    break;
                case 2:
                    manager.display();
                    System.out.print("Enter email of user to delete: ");
                    String emailDel = scanner.nextLine();
                    if (emailDel.trim().isEmpty()) { System.out.println("Please provide an email."); break; }
                    boolean removed = manager.deleteByEmail(emailDel);
                    System.out.println(removed ? "User deleted successfully." : "No user found with that email.");
                    break;
                case 3:
                    manager.display();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
        scanner.close();
    }
}

