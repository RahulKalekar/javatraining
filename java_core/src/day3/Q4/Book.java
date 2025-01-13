package day3.Q4;

public class Book {
    int id;
    String ISBN;
    String title;
    String author;
    double price;

    public Book(int id, String ISBN, String title, String author, double price) {
        this.id = id;
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", ISBN='" + ISBN + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }
}