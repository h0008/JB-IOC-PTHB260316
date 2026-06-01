package moviemanager;

import java.util.ArrayList;
import java.util.List;

public class MovieManager<T extends Movie> {
    private List<T> movies;

    public MovieManager() {
        this.movies = new ArrayList<>();
    }

    public void addMovie(T movie) {
        movies.add(movie);
        System.out.println("Movie added successfully.");
    }

    public void removeMovie(int id) {
        T movieToRemove = findMovieById(id);
        if (movieToRemove != null) {
            movies.remove(movieToRemove);
            System.out.println("Movie deleted successfully.");
        } else {
            System.out.println("Movie to delete not found!");
        }
    }

    public T findMovieById(int id) {
        for (T movie : movies) {
            if (movie.getId() == id) {
                return movie;
            }
        }
        return null;
    }

    public void editMovie(int id, T updatedMovie) {
        T movie = findMovieById(id);
        if (movie != null) {
            movie.setTitle(updatedMovie.getTitle());
            movie.setDirector(updatedMovie.getDirector());
            movie.setReleaseDate(updatedMovie.getReleaseDate());
            movie.setRating(updatedMovie.getRating());
            System.out.println("Movie updated successfully!");
        } else {
            System.out.println("Cannot find movie with id = " + id);
        }
    }

    public void showMovies() {
        System.out.println("Movie list:");
        for (T movie : movies) {
            System.out.println(movie);
        }
    }

    public void searchMovieByTitle(String title) {
        boolean found = false;
        for (T movie : movies) {
            if (movie.getTitle().toLowerCase().contains(title.toLowerCase())) {
                System.out.println("Movie found: " + movie);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Movie not found.");
        }
    }

    public void filterMoviesByRating(double minRating) {
        System.out.println("Movies with rating greater than " + minRating + ":");
        for (T movie : movies) {
            if (movie.getRating() > minRating) {
                System.out.println(movie);
            }
        }
    }
}
