
package ShapeManagement;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[2];
        shapes[0] = new Rectangle("Rectangle Shape", 5.0, 10.0);
        shapes[1] = new Circle("Circle Shape", 7.0);

        for (Shape shape : shapes) {
            shape.displayInfo();
            System.out.println("Area: " + shape.getArea());
            System.out.println("Perimeter: " + shape.getPerimeter());

            if (shape instanceof Drawable) {
                ((Drawable) shape).draw();
            }
            System.out.println();
        }
    }
}
