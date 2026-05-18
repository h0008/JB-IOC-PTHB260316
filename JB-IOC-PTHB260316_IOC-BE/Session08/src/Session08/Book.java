package Session08;

public class Book {
    private String title;
    private String author;
    private double price;

    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public void displayInformation() {
        System.out.println("Title: " + this.title + ", Author: " + this.author + ", Price: " + this.price);
    }
}

