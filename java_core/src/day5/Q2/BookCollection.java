package day5.Q2;


import java.util.*;

public class BookCollection {
    public static void main(String[] args) {
        String ownerName;
        List<Book> books = new ArrayList<>();

        Book book1 = new Book("java in depth", "respective author");
        Book book2 = new Book("secret of nagas", "amish");
        Book book3 = new Book("Malgudi days", "RK narayan");

        books.add(book1);
        books.add(book2);
        books.add(book3);

        System.out.println(hasBook(new Book("java in depth","respective author"),books));
        System.out.println(hasBook(new Book("Game of thrones", "great guy"),books));
        sortBookByTitle(books);
        System.out.println(books);
        sortBookByAuthor(books);
        System.out.println(books);
    }

    public static boolean hasBook(Book b, List<Book> books){
        for (Book book : books)
        {
            if (book.equals(b)){
                return true;
            }
        }
        return false;
    }

    public static void sortBookByTitle(List<Book> books){
        BookSortByTitle sortByTitle = new BookSortByTitle();
        Collections.sort(books,sortByTitle);
    }

    public static void sortBookByAuthor(List<Book> books){
        BookSortByAuthor sortByAuthor = new BookSortByAuthor();
        Collections.sort(books,sortByAuthor);
    }

}