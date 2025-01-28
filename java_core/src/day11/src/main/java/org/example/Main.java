package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        BookDao bookDao = new BookDaoImp();

        try {
            // Add sample books
            Book book1 = new Book("123456", "Tenali ", "Bijaynagar", 10.99);
            Book book2 = new Book("987654", "Akbar Birbal", "Indian", 8.99);
            bookDao.addBook(book1);
            bookDao.addBook(book2);
            System.out.println("Books added.");



            // Retrieve all books
            List<Book> books = bookDao.getAllBooks();
            System.out.println("All books:");
            for (Book book : books) {
                System.out.println(book.getId() + ": " + book.getTitle());
            }



            // Update a book
            book1.setPrice(50.00);
            bookDao.updateBook(book1.getId(), book1);
            System.out.println("Book updated: " + book1.getTitle() + " -> " + book1.getPrice());


            // Retrieve a specific book by ID
            Book retrievedBook = bookDao.getBookById(book1.getId());
            System.out.println("Retrieved book: " + retrievedBook.getTitle());

            // Delete a book
            bookDao.deleteBook(book2.getId());
            System.out.println("Book deleted: " + book2.getTitle());

            // List all books after deletion
            books = bookDao.getAllBooks();
            System.out.println("Books after deletion:");
            for (Book book : books) {
                System.out.println(book.getId() + ": " + book.getTitle());
            }

        } catch (DaoException e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
