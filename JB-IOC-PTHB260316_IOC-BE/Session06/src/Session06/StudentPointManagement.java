package Session06;

import java.util.Scanner;

public class StudentPointManagement {
    private double[] scores;
    private int count;

    public StudentPointManagement() {
        scores = new double[100];
        count = 0;
    }

    // 1. Enter student score list
    public void enterScores() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = scanner.nextInt();
        if (n <= 0 || n > 100) {
            System.out.println("Number of students must be between 1 and 100!");
            return;
        }
        count = n;
        for (int i = 0; i < n; i++) {
            System.out.print("Enter score for student " + (i + 1) + ": ");
            double score = scanner.nextDouble();
            if (score < 0 || score > 10) {
                System.out.println("Score must be between 0 and 10! Try again.");
                i--;
                continue;
            }
            scores[i] = score;
        }
        System.out.println("Scores entered successfully!");
    }

    // 2. Display score list
    public void displayScores() {
        if (count == 0) {
            System.out.println("No scores entered yet!");
            return;
        }
        System.out.println("\n========== STUDENT SCORE LIST ==========");
        for (int i = 0; i < count; i++) {
            System.out.println("Student " + (i + 1) + ": " + scores[i]);
        }
        System.out.println("=======================================\n");
    }

    // 3. Calculate average score
    public void calculateAverage() {
        if (count == 0) {
            System.out.println("No scores entered yet!");
            return;
        }
        double sum = 0;
        for (int i = 0; i < count; i++) {
            sum += scores[i];
        }
        double average = sum / count;
        System.out.println("Average score: " + String.format("%.2f", average));
    }

    // 4. Find highest and lowest scores
    public void findHighestAndLowest() {
        if (count == 0) {
            System.out.println("No scores entered yet!");
            return;
        }
        double max = scores[0];
        double min = scores[0];
        for (int i = 1; i < count; i++) {
            if (scores[i] > max) {
                max = scores[i];
            }
            if (scores[i] < min) {
                min = scores[i];
            }
        }
        System.out.println("Highest score: " + max);
        System.out.println("Lowest score: " + min);
    }

    // 5. Count passing and failing students (pass >= 5, fail < 5)
    public void countPassingAndFailing() {
        if (count == 0) {
            System.out.println("No scores entered yet!");
            return;
        }
        int passing = 0;
        int failing = 0;
        for (int i = 0; i < count; i++) {
            if (scores[i] >= 5) {
                passing++;
            } else {
                failing++;
            }
        }
        System.out.println("Number of passing students (score >= 5): " + passing);
        System.out.println("Number of failing students (score < 5): " + failing);
    }

    // 6. Sort scores in ascending order (bubble sort)
    public void sortScoresAscending() {
        if (count == 0) {
            System.out.println("No scores entered yet!");
            return;
        }
        double[] temp = new double[count];
        for (int i = 0; i < count; i++) {
            temp[i] = scores[i];
        }
        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < count - i - 1; j++) {
                if (temp[j] > temp[j + 1]) {
                    double swap = temp[j];
                    temp[j] = temp[j + 1];
                    temp[j + 1] = swap;
                }
            }
        }
        System.out.println("\n========== SORTED SCORES (ASCENDING) ==========");
        for (int i = 0; i < count; i++) {
            System.out.println("Position " + (i + 1) + ": " + temp[i]);
        }
        System.out.println("==============================================\n");
    }

    // 7. Count good and excellent students (score >= 8)
    public void countGoodAndExcellent() {
        if (count == 0) {
            System.out.println("No scores entered yet!");
            return;
        }
        int good = 0;
        for (int i = 0; i < count; i++) {
            if (scores[i] >= 8) {
                good++;
            }
        }
        System.out.println("Number of good/excellent students (score >= 8): " + good);
    }

    // Display menu options
    public void displayMenu() {
        System.out.println("\n================= STUDENT SCORE MANAGEMENT MENU =================");
        System.out.println("1. Enter student score list");
        System.out.println("2. Display score list");
        System.out.println("3. Calculate average score");
        System.out.println("4. Find highest and lowest scores");
        System.out.println("5. Count passing and failing students");
        System.out.println("6. Sort scores in ascending order");
        System.out.println("7. Statistics of good and excellent students");
        System.out.println("8. Exit");
        System.out.println("==================================================================");
    }

    // Run the program with menu-driven interface
    public void run() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            displayMenu();
            System.out.print("Choose an option (1-8): ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    enterScores();
                    break;
                case 2:
                    displayScores();
                    break;
                case 3:
                    calculateAverage();
                    break;
                case 4:
                    findHighestAndLowest();
                    break;
                case 5:
                    countPassingAndFailing();
                    break;
                case 6:
                    sortScoresAscending();
                    break;
                case 7:
                    countGoodAndExcellent();
                    break;
                case 8:
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option! Please enter a number between 1 and 8.");
            }
        } while (choice != 8);
    }
}
