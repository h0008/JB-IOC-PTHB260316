package Session03;

import java.util.Scanner;

public class ManageScore {
    static void main() {
        Scanner scanner = new Scanner(System.in);
        int totalStudents = 0;
        double sumScore = 0;
        double maxScore = -1;
        double minScore = 11;

        while (true) {
            System.out.println("\n--- Student Score Management ---");
            System.out.println("1. Enter Student Scores");
            System.out.println("2. Display Statistics");
            System.out.println("3. Exit");
            System.out.print("Select an option: ");
            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    while (true) {
                        System.out.print("Enter student score (0-10, or -1 to finish): ");
                        double score;
                        try {
                            score = Double.parseDouble(scanner.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. Please enter a number.");
                            continue;
                        }

                        if (score == -1) {
                            break;
                        }

                        if (score < 0 || score > 10) {
                            System.out.println("Invalid score. Please enter a score between 0 and 10.");
                            continue;
                        }

                        totalStudents++;
                        sumScore += score;
                        if (score > maxScore) {
                            maxScore = score;
                        }
                        if (score < minScore) {
                            minScore = score;
                        }

                        String classification = getString(score);
                        System.out.println("Classification: " + classification);
                    }
                    break;
                case 2:
                    if (totalStudents == 0) {
                        System.out.println("There is no data");
                    } else {
                        System.out.println("\n--- Statistics ---");
                        System.out.println("Number of students entered: " + totalStudents);
                        System.out.printf("GPA points: %.2f\n", (sumScore / totalStudents));
                        System.out.println("Highest point: " + maxScore);
                        System.out.println("Lowest point: " + minScore);
                    }
                    break;
                case 3:
                    System.out.println("End of program.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static String getString(double score) {
        String classification;
        if (score < 5) {
            classification = "Weak";
        } else if (score < 7) {
            classification = "Average";
        } else if (score < 8) {
            classification = "Pretty";
        } else if (score < 9) {
            classification = "Good";
        } else {
            classification = "Excellent";
        }
        return classification;
    }
}
