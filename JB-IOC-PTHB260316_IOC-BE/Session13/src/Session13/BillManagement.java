package Session13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BillManagement {

    public static class Invoice {
        private int id;
        private String invoiceCode;
        private double amount;

        public Invoice() {
        }

        public Invoice(int id, String invoiceCode, double amount) {
            this.id = id;
            this.invoiceCode = invoiceCode;
            this.amount = amount;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getInvoiceCode() {
            return invoiceCode;
        }

        public void setInvoiceCode(String invoiceCode) {
            this.invoiceCode = invoiceCode;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

        @Override
        public String toString() {
            return "ID : " + id + " , Invoice code: " + invoiceCode + ", Amount: " + amount;
        }
    }

    public interface Manage<T> {
        void add(T item);
        void update(int index, T item);
        void delete(int index);
        void display();
    }

    public static class InvoiceManager implements Manage<Invoice> {
        private List<Invoice> invoices;
        private int currentId;

        public InvoiceManager() {
            this.invoices = new ArrayList<>();
            this.currentId = 1;
        }

        public int generateId() {
            return currentId++;
        }

        @Override
        public void add(Invoice item) {
            invoices.add(item);
        }

        @Override
        public void update(int index, Invoice item) {
            if (index >= 0 && index < invoices.size()) {
                invoices.set(index, item);
            }
        }

        @Override
        public void delete(int index) {
            if (index >= 0 && index < invoices.size()) {
                invoices.remove(index);
            }
        }

        @Override
        public void display() {
            if (invoices.isEmpty()) {
                System.out.println("No invoices available.");
                return;
            }
            for (int i = 0; i < invoices.size(); i++) {
                System.out.println((i + 1) + ". " + invoices.get(i).toString());
            }
        }

        public int findIndexById(int id) {
            for (int i = 0; i < invoices.size(); i++) {
                if (invoices.get(i).getId() == id) {
                    return i;
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InvoiceManager invoiceManager = new InvoiceManager();
        int choice;

        do {
            System.out.println("\n**************** BILL MANAGEMENT MENU ****************");
            System.out.println("1. Add invoice");
            System.out.println("2. Edit invoice");
            System.out.println("3. Delete invoice");
            System.out.println("4. Display invoice list");
            System.out.println("5. Exit");
            System.out.print("Your choice:\n");

            choice = -1;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                // Ignore
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter invoice code:\n");
                    String codeAdd = scanner.nextLine();

                    double amountAdd = -1;
                    while (amountAdd < 0) {
                        System.out.print("Enter amount:\n");
                        try {
                            amountAdd = Double.parseDouble(scanner.nextLine());
                            if (amountAdd < 0) {
                                System.out.println("Please enter a real number >= 0 !");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Please enter a real number >= 0 !");
                        }
                    }
                    int newId = invoiceManager.generateId();
                    invoiceManager.add(new Invoice(newId, codeAdd, amountAdd));
                    System.out.println("Invoice added successfully.");
                    break;

                case 2:
                    invoiceManager.display();
                    System.out.print("Enter invoice id to edit:\n");
                    int idEdit = -1;
                    try {
                        idEdit = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        // ignore
                    }

                    int indexEdit = invoiceManager.findIndexById(idEdit);
                    if (indexEdit != -1) {
                        String newCode = "";
                        while (newCode.trim().isEmpty()) {
                            System.out.print("Enter new invoice code:\n");
                            newCode = scanner.nextLine();
                            if (newCode.trim().isEmpty()) {
                                System.out.println("Please do not leave it blank!");
                            }
                        }

                        double newAmount = -1;
                        while (newAmount < 0) {
                            System.out.print("Enter new amount:\n");
                            try {
                                newAmount = Double.parseDouble(scanner.nextLine());
                                if (newAmount < 0) {
                                    System.out.println("Please enter a real number >= 0 !");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Please enter a real number >= 0 !");
                            }
                        }

                        invoiceManager.update(indexEdit, new Invoice(idEdit, newCode, newAmount));
                        System.out.println("Invoice edited successfully.");
                    } else {
                        System.out.println("No invoice found with id = " + idEdit);
                    }
                    break;

                case 3:
                    invoiceManager.display();
                    System.out.print("Enter invoice id to delete:\n");
                    int idDelete = -1;
                    try {
                        idDelete = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        // ignore
                    }

                    int indexDelete = invoiceManager.findIndexById(idDelete);
                    if (indexDelete != -1) {
                        invoiceManager.delete(indexDelete);
                        System.out.println("Invoice deleted successfully.");
                    } else {
                        System.out.println("No invoice found with id = " + idDelete);
                    }
                    break;

                case 4:
                    invoiceManager.display();
                    break;

                case 5:
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}

