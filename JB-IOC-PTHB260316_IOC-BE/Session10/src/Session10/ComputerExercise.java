package Session10;

class Computer {
    public double calculatePrice(double basePrice) {
        System.out.println("Formula: Original price only");
        return basePrice;
    }

    public double calculatePrice(double basePrice, double tax) {
        System.out.println("Formula: Original price + tax");
        return basePrice + tax;
    }

    public double calculatePrice(double basePrice, double tax, double discount) {
        System.out.println("Formula: Original price + tax - discount");
        return basePrice + tax - discount;
    }
}

public class ComputerExercise {
    public static void main(String[] args) {
        Computer computer = new Computer();

        System.out.println("Price 1: " + computer.calculatePrice(1000));
        System.out.println("-----------------------------------");

        System.out.println("Price 2: " + computer.calculatePrice(1000, 100));
        System.out.println("-----------------------------------");

        System.out.println("Price 3: " + computer.calculatePrice(1000, 100, 50));
    }
}

