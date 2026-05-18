package Session08;

public class Student {
    private int id;
    private String name;
    private int age;

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public void displayInformation() {
        System.out.printf("ID: %d, Name: %s, Age: %d%n", id, name, age);
    }
}

