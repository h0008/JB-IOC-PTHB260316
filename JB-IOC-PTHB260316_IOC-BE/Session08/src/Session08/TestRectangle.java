package Session08;

import java.util.ArrayList;
import java.util.List;

public class TestRectangle {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(3.0, 4.0);
        Rectangle r2 = new Rectangle(5.0, 2.0);
        Rectangle r3 = new Rectangle(4.5, 3.5);

        Rectangle[] rectangles = {r1, r2, r3};

        for (int i = 0; i < rectangles.length; i++) {
            Rectangle r = rectangles[i];
            System.out.println("Rectangle " + (i + 1) + ": width=" + r.getWidth() +
                               ", height=" + r.getHeight() +
                               ", area=" + r.getArea() +
                               ", perimeter=" + r.getPerimeter());
        }

        double maxArea = r1.getArea();
        if (r2.getArea() > maxArea) maxArea = r2.getArea();
        if (r3.getArea() > maxArea) maxArea = r3.getArea();

        List<Integer> largestRectangles = new ArrayList<>();
        for (int i = 0; i < rectangles.length; i++) {
            if (rectangles[i].getArea() == maxArea) {
                largestRectangles.add(i);
            }
        }

        System.out.println();
        if (largestRectangles.size() > 1) {
            System.out.println("There are multiple rectangles with the largest area (" + maxArea + ").");
        } else {
            int index = largestRectangles.get(0);
            Rectangle largest = rectangles[index];
            System.out.println("Largest area = " + maxArea + " (Rectangle " + (index + 1) +
                               ": width=" + largest.getWidth() + ", height=" + largest.getHeight() + ")");
        }
    }
}

