package Session13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AttendanceManagement {
    static class Student {
        private int id;
        private String name;
        public Student() {}
        public Student(int id, String name) { this.id = id; this.name = name; }
        public int getId() { return id; }
        public void setId(int id) { this.id = id; }
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        @Override public String toString() { return "ID : " + id + " , Student name: " + name; }
    }

    public interface Manage<T> {
        void add(T item);
        void update(int index, T item);
        void delete(int index);
        void display();
    }

    static class AttendanceManager implements Manage<Student> {
        private final List<Student> students = new ArrayList<>();
        private int nextId = 1;
        public int generateId() { return nextId++; }
        @Override public void add(Student item) { students.add(item); }
        @Override public void update(int index, Student item) { if (index >= 0 && index < students.size()) students.set(index, item); }
        @Override public void delete(int index) { if (index >= 0 && index < students.size()) students.remove(index); }
        @Override public void display() { if (students.isEmpty()) { System.out.println("No students in the attendance list."); return; } for (Student s : students) System.out.println(s.toString()); }
        public int findIndexById(int id) { for (int i = 0; i < students.size(); i++) if (students.get(i).getId() == id) return i; return -1; }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AttendanceManager manager = new AttendanceManager();
        int choice;
        do {
            System.out.println("\n**************** ATTENDANCE MANAGEMENT MENU ****************");
            System.out.println("1. Add student");
            System.out.println("2. Edit student");
            System.out.println("3. Delete student");
            System.out.println("4. Display student list");
            System.out.println("5. Exit");
            System.out.print("Your choice: ");
            choice = -1;
            try { choice = Integer.parseInt(scanner.nextLine()); } catch (NumberFormatException e) { System.out.println("Invalid input. Please enter a number from 1 to 5."); continue; }
            switch (choice) {
                case 1:
                    String nameAdd = "";
                    while (nameAdd.trim().isEmpty()) { System.out.print("Enter student name: "); nameAdd = scanner.nextLine(); if (nameAdd.trim().isEmpty()) System.out.println("Please do not leave it blank!"); }
                    int id = manager.generateId();
                    manager.add(new Student(id, nameAdd));
                    System.out.println("Student added successfully. ID = " + id);
                    break;
                case 2:
                    manager.display();
                    System.out.print("Enter student id to edit: ");
                    int idEdit = -1;
                    try { idEdit = Integer.parseInt(scanner.nextLine()); } catch (NumberFormatException e) { System.out.println("Invalid id."); break; }
                    int idxEdit = manager.findIndexById(idEdit);
                    if (idxEdit == -1) { System.out.println("No student found with id = " + idEdit); break; }
                    String newName = "";
                    while (newName.trim().isEmpty()) { System.out.print("Enter new student name: "); newName = scanner.nextLine(); if (newName.trim().isEmpty()) System.out.println("Please do not leave it blank!"); }
                    manager.update(idxEdit, new Student(idEdit, newName));
                    System.out.println("Student edited successfully.");
                    break;
                case 3:
                    manager.display();
                    System.out.print("Enter student id to delete: ");
                    int idDelete = -1;
                    try { idDelete = Integer.parseInt(scanner.nextLine()); } catch (NumberFormatException e) { System.out.println("Invalid id."); break; }
                    int idxDelete = manager.findIndexById(idDelete);
                    if (idxDelete == -1) { System.out.println("No student found with id = " + idDelete); break; }
                    manager.delete(idxDelete);
                    System.out.println("Student deleted successfully.");
                    break;
                case 4:
                    manager.display();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
        scanner.close();
    }
}
