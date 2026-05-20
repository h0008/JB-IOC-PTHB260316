package Session10;

class Car {
    private int currentSpeed = 0;

    public void accelerate() {
        currentSpeed += 10;
        System.out.println("Car accelerates by default: +10 km/h");
    }

    public void accelerate(int speed) {
        currentSpeed += speed;
        System.out.println("Car accelerates by " + speed + " km/h");
    }

    public void accelerate(int speed, int seconds) {
        int increase = speed * seconds;
        currentSpeed += increase;
        System.out.println("Car accelerates " + increase + " km/h (speed x time)");
    }

    public void printStatus() {
        System.out.println("Current speed: " + currentSpeed + " km/h");
    }
}

public class CarExercise {
    public static void main(String[] args) {
        Car myCar = new Car();

        myCar.accelerate();
        myCar.printStatus();

        System.out.println(); // Adding an empty line to cleanly separate outputs like the picture

        myCar.accelerate(20);
        myCar.printStatus();

        System.out.println();

        // Multiplying 10 by 2 gives us the 20km/h boost from the prompt's image.
        myCar.accelerate(10, 2);
        myCar.printStatus();
    }
}

