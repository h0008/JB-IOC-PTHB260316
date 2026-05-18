public class Main {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(5.0, 10.0);

        rectangle.printInfo();
        System.out.println("Area: " + rectangle.getArea());
        System.out.println("Perimeter: " + rectangle.getPerimeter());
    }
}

