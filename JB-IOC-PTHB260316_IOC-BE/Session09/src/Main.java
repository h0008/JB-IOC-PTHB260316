public class Main {
    public static void main(String[] args) {
        Student student1 = new Student(1, "Alice", 20, 3.8);
        Student student2 = new Student(2, "Bob", 22, 3.5);
        Student student3 = new Student(3, "Charlie", 21, 3.9);

        student1.printInfo();
        student2.printInfo();
        student3.printInfo();

        System.out.println("Total number of students created: " + Student.getCount());
    }
}
