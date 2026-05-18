package Session09;

public class Student {
    private int id;
    private String fullName;
    private int age;
    private double gpa;

    private static int count = 0;

    public static final double MIN_GPA = 0.0;
    public static final double MAX_GPA = 4.0;

    public Student(int id, String fullName, int age, double gpa) {
        this.id = id;
        this.fullName = fullName;
        this.age = age;
        this.gpa = gpa;
        count++;
    }

    public static int getCount() {
        return count;
    }

    public void printInfo() {
        System.out.println("ID: " + id);
        System.out.println("Full Name: " + fullName);
        System.out.println("Age: " + age);
        System.out.println("GPA: " + gpa);
        System.out.println("-------------------------");
    }
}

