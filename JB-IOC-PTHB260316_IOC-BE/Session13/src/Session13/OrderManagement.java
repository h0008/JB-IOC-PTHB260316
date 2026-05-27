package Session13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Order {
    private String orderCode;
    private String customerName;

    public Order() {
    }

    public Order(String orderCode, String customerName) {
        this.orderCode = orderCode;
        this.customerName = customerName;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public String toString() {
        return "Order code: " + orderCode + ", Customer name: " + customerName;
    }
}

interface Manage<T> {
    void add(T item);
    void update(int index, T item);
    void delete(int index);
    void display();
}

class OrderManager implements Manage<Order> {
    private List<Order> orders;

    public OrderManager() {
        this.orders = new ArrayList<>();
    }

    @Override
    public void add(Order item) {
        orders.add(item);
    }

    @Override
    public void update(int index, Order item) {
        if (index >= 0 && index < orders.size()) {
            orders.set(index, item);
        }
    }

    @Override
    public void delete(int index) {
        if (index >= 0 && index < orders.size()) {
            orders.remove(index);
        }
    }

    @Override
    public void display() {
        if (orders.isEmpty()) {
            System.out.println("No orders available.");
            return;
        }
        for (int i = 0; i < orders.size(); i++) {
            System.out.println((i + 1) + ". " + orders.get(i).toString());
        }
    }

    public int findIndexByOrderCode(String orderCode) {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getOrderCode().equalsIgnoreCase(orderCode)) {
                return i;
            }
        }
        return -1;
    }
}

public class OrderManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        OrderManager orderManager = new OrderManager();
        int choice;

        do {
            System.out.println("**************** ORDER MANAGEMENT MENU ****************");
            System.out.println("1. Add order");
            System.out.println("2. Edit order");
            System.out.println("3. Delete order");
            System.out.println("4. Display order list");
            System.out.println("5. Exit");
            System.out.print("Your choice: ");

            choice = -1;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                // Ignore and let loop continue
            }

            switch (choice) {
                case 1:
                    String orderCodeAdd = "";
                    while (orderCodeAdd.trim().isEmpty()) {
                        System.out.print("Enter order code: ");
                        orderCodeAdd = scanner.nextLine();
                        if (orderCodeAdd.trim().isEmpty()) {
                            System.out.println("Please do not leave it blank!");
                        }
                    }
                    System.out.print("Enter customer name: ");
                    String customerNameAdd = scanner.nextLine();
                    orderManager.add(new Order(orderCodeAdd, customerNameAdd));
                    System.out.println("Order added successfully.");
                    break;
                case 2:
                    orderManager.display();
                    System.out.print("Enter order code to edit: ");
                    String orderCodeEdit = scanner.nextLine();
                    int indexEdit = orderManager.findIndexByOrderCode(orderCodeEdit);
                    if (indexEdit != -1) {
                        System.out.print("Enter new customer name: ");
                        String newCustomerName = scanner.nextLine();
                        orderManager.update(indexEdit, new Order(orderCodeEdit, newCustomerName));
                        System.out.println("Order edited successfully.");
                    } else {
                        System.out.println("Order not found!");
                    }
                    break;
                case 3:
                    orderManager.display();
                    System.out.print("Enter order code to delete: ");
                    String orderCodeDelete = scanner.nextLine();
                    int indexDelete = orderManager.findIndexByOrderCode(orderCodeDelete);
                    if (indexDelete != -1) {
                        orderManager.delete(indexDelete);
                        System.out.println("Order deleted successfully.");
                    } else {
                        System.out.println("Order not found!");
                    }
                    break;
                case 4:
                    orderManager.display();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
