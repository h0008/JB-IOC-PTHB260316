public class Rectangle {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return (width + height) * 2.0;
    }

    public void printInfo() {
        System.out.println("Rectangle details:");
        System.out.println("Width: " + width);
        System.out.println("Height: " + height);
    }
}

