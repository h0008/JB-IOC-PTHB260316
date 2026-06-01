package moviemanager;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final MovieManager<Movie> manager = new MovieManager<>();
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public static void main(String[] args) {
        while (true) {
            System.out.println("Choose function:");
            System.out.println("1. Add movie");
            System.out.println("2. Delete movie");
            System.out.println("3. Edit movie");
            System.out.println("4. Show movies");
            System.out.println("5. Search movie by title");
            System.out.println("6. Filter movies by rating");
            System.out.println("7. Exit");

            int choice = -1;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    addMovie();
                    break;
                case 2:
                    deleteMovie();
                    break;
                case 3:
                    editMovie();
                    break;
                case 4:
                    manager.showMovies();
                    break;
                case 5:
                    searchMovie();
                    break;
                case 6:
                    filterMovies();
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void addMovie() {
        try {
            System.out.println("Enter movie ID:");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter movie title:");
            String title = scanner.nextLine();
            System.out.println("Enter director:");
            String director = scanner.nextLine();
            System.out.println("Enter release date (dd-MM-yyyy):");
            LocalDate releaseDate = LocalDate.parse(scanner.nextLine(), formatter);
            System.out.println("Enter rating:");
            double rating = Double.parseDouble(scanner.nextLine());

            manager.addMovie(new Movie(id, title, director, releaseDate, rating));
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid numerical format entered.");
        } catch (DateTimeParseException e) {
            System.out.println("Error: Invalid date format. Please use dd-MM-yyyy.");
        }
    }

    private static void deleteMovie() {
        try {
            System.out.println("Enter movie ID to delete:");
            int id = Integer.parseInt(scanner.nextLine());
            manager.removeMovie(id);
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid ID format.");
        }
    }

    private static void editMovie() {
        try {
            System.out.println("Enter movie ID to edit:");
            int id = Integer.parseInt(scanner.nextLine());
            Movie existing = manager.findMovieById(id);
            if (existing == null) {
                System.out.println("Cannot find movie with id = " + id);
                return;
            }

            System.out.println("Enter movie title:");
            String title = scanner.nextLine();
            System.out.println("Enter director:");
            String director = scanner.nextLine();
            System.out.println("Enter release date (dd-MM-yyyy):");
            LocalDate releaseDate = LocalDate.parse(scanner.nextLine(), formatter);
            System.out.println("Enter rating:");
            double rating = Double.parseDouble(scanner.nextLine());

            manager.editMovie(id, new Movie(id, title, director, releaseDate, rating));
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid numerical format entered.");
        } catch (DateTimeParseException e) {
            System.out.println("Error: Invalid date format. Please use dd-MM-yyyy.");
        }
    }

    private static void searchMovie() {
        System.out.println("Enter movie title to search:");
        String title = scanner.nextLine();
        manager.searchMovieByTitle(title);
    }

    private static void filterMovies() {
        try {
            System.out.println("Enter minimum rating to filter:");
            double rating = Double.parseDouble(scanner.nextLine());
            manager.filterMoviesByRating(rating);
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid rating format.");
        }
    }
}
